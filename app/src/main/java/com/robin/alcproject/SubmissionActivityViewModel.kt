package com.robin.alcproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.robin.alcproject.datasource.LeaderboardApiService
import com.robin.alcproject.datasource.SubmissionApiEndpoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

/**
 * @author robin
 * Created on 9/10/20
 */
class SubmissionActivityViewModel: ViewModel() {
    private val apiService  = LeaderboardApiService.buildService(SubmissionApiEndpoint::class.java)
    private lateinit var successHandler : SubmissionResultListener
    private val observer = Observer<Response<Unit>> {
        if(it.isSuccessful){
            successHandler.showResult(true)
        } else{
            successHandler.showResult(false)
        }
    }

    fun submitProject(
            firstName : String,
            lastName : String,
            emailAddress : String,
            githubURL : String
    ){
        val result: LiveData<Response<Unit>> = LiveDataReactiveStreams.fromPublisher(
                apiService.submitProject(firstName, lastName, emailAddress, githubURL)
                        .observeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .toFlowable()
        )
        result.observeForever(observer)
    }

    fun setSubmissionListener (submissionListener: SubmissionResultListener) {
        this.successHandler = submissionListener
    }

    interface SubmissionResultListener{
        fun showResult(isSuccessful : Boolean)
    }
}