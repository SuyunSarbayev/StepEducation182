package kz.step.stepeducation182.data.network

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("latest")
    fun initiateGetData(): Observable<Response<ReturnData>>
}