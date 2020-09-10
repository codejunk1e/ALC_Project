package com.robin.alcproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.robin.alcproject.datasource.ApiEndpoint
import com.robin.alcproject.datasource.ApiService
import com.robin.alcproject.datasource.RxResult
import com.robin.alcproject.models.IQItem
import com.robin.alcproject.models.SkillItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

typealias ObservableLearningHours = LiveData<RxResult<List<SkillItem>>>
typealias ObservableSkillIQ = LiveData<RxResult<List<IQItem>>>


/**
 * @author robin
 * Created on 9/9/20
 */
class MainActivityViewModel: ViewModel(){

    private val apiService  = ApiService.buildService(ApiEndpoint::class.java)

    private lateinit var _observableLearningHours : ObservableLearningHours
    val observableLearningHours : ObservableLearningHours
            get() = _observableLearningHours

    private lateinit var _observableSkillIQ : ObservableSkillIQ
    val observableSkillIQ : ObservableSkillIQ
        get() = _observableSkillIQ

    private fun getSkills() {
        _observableLearningHours = LiveDataReactiveStreams.fromPublisher(
                apiService.fetchHours()
                    .subscribeOn(Schedulers.io())
                    .map { RxResult.success (it) }
                    .onErrorReturn { RxResult.error(it) }
                    .observeOn(AndroidSchedulers.mainThread())
                    .toFlowable()
            )
    }

    private fun getIQScores(){
        _observableSkillIQ = LiveDataReactiveStreams.fromPublisher(
                apiService.fetchIQ()
                    .subscribeOn(Schedulers.io())
                    .map { RxResult.success (it) }
                    .onErrorReturn { RxResult.error(it) }
                    .observeOn(AndroidSchedulers.mainThread())
                    .toFlowable()
            )
    }

    fun fetchNeedData() {
        getSkills()
        getIQScores()
    }
}