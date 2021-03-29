package kz.step.stepeducation182.data.network

import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("latest")
    fun initiateGetData(): Call<ReturnData>
}