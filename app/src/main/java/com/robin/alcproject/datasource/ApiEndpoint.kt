package com.robin.alcproject.datasource
import com.robin.alcproject.models.IQItem
import com.robin.alcproject.models.SkillItem
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

/**
 * @author robin
 * Created on 9/9/20
 */
interface ApiEndpoint{

    @GET(" /api/hours")
    fun fetchHours(): Single<List<SkillItem>>


    @GET(" /api/skilliq")
    fun fetchIQ(): Single<List<IQItem>>
}