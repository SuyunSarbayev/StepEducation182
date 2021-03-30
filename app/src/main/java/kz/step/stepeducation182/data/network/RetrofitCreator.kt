package kz.step.stepeducation182.data.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitCreator {

    companion object{
        val BASE_URL = "https://api.exchangeratesapi.io/"
    }

    fun initializeRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun initializeApiInterface(): Api{
        return initializeRetrofit().create(Api::class.java)
    }

//    Dagger ==== Koin
//    Retrofit ==== OkHttpClient ==== Volley
//    RxJava ==== Kotlin Coroutines

}