package com.robin.alcproject.datasource

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author robin
 * Created on 9/9/20
 */
object ApiService {

     private val retrofit: Retrofit
            get() = builder.build()

    private const val BASE_URL = "https://gadsapi.herokuapp.com/"
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val okHttp = OkHttpClient.Builder()
        .readTimeout(15, TimeUnit.SECONDS)
        .addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                return chain.proceed(chain.request().newBuilder().build())
            }
        })
        .addInterceptor(logger)

    private val builder = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(okHttp.build())

    @JvmStatic
    fun <S> buildService(serviceType : Class<S>) : S {
        return retrofit.create(serviceType)
    }
}