package com.base.repository.network

import com.base.model.retrofit.response.details.F1PilotDetails
import com.base.model.retrofit.response.pilots.F1PilotsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface APIInterface {


    @GET("/oguzayan/kuka/drivers")
    suspend fun getF1PilotList(): F1PilotsResponse


    @GET("oguzayan/kuka/driverDetail/{id}")
    suspend fun getF1PilotDetail(@Path("id") id: Int): F1PilotDetails


}
