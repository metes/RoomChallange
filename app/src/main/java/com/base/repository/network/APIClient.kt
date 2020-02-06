package com.base.repository.network

import com.base.BuildConfig
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.core.KoinComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient : KoinComponent {

    private val stethoInterceptor: StethoInterceptor? by lazy {
        if (BuildConfig.DEBUG) StethoInterceptor() else null
    }

    private val retrofitClient: APIInterface by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(APIInterface::class.java)
    }

    private val okHttpClient: OkHttpClient
        get() {
            val clientBuilder = OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val builder = chain.request().newBuilder()
                    builder.addHeader("Content-Type", "application/json")
                    chain.proceed(builder.build())
                }
            stethoInterceptor?.let {
                clientBuilder.addNetworkInterceptor(it)
            }
            return clientBuilder.build()
        }



    suspend fun getF1PilotList() = retrofitClient.getF1PilotList()
    suspend fun getF1PilotDetail(id: Int) = retrofitClient.getF1PilotDetail(id)

}



