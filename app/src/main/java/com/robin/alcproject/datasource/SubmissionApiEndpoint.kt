package com.robin.alcproject.datasource
import com.robin.alcproject.datasource.LeaderboardApiService.SUBMISSION_FORM_URL
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Url

/**
 * @author robin
 * Created on 9/9/20
 */
interface SubmissionApiEndpoint{

    @POST
    @FormUrlEncoded
    fun submitProject(
            @Field("entry.1877115667") firstName : String,
            @Field("entry.2006916086") lastName : String,
            @Field("entry.1824927963") emailAddress : String,
            @Field("entry.284483984") githubURL : String,
            @Url url: String = SUBMISSION_FORM_URL
    ) : Single<Response<Unit>>
}