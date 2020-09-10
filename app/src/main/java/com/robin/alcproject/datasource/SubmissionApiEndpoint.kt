package com.robin.alcproject.datasource
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

/**
 * @author robin
 * Created on 9/9/20
 */
interface SubmissionApiEndpoint{

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    fun submitProject(
            @Field("entry.1877115667") firstName : String,
            @Field("entry.2006916086") lastName : String,
            @Field("entry.1824927963") emailAddress : String,
            @Field("entry.284483984") githubURL : String,
    ) : Single<Response<Unit>>


    @GET("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    fun submitProjectWithResponse(
            @Query("entry.1877115667") firstName : String,
            @Query("entry.2006916086") lastName : String,
            @Query("entry.1824927963") emailAddress : String,
            @Query("entry.284483984") githubURL : String,
    ) : Single<Unit>


}