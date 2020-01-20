package fr.henry.boxomovies.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private val retrofit: Retrofit
    private val okhttpClient: OkHttpClient
    val serviceAPI: ApiService

    init {
        val builder = OkHttpClient().newBuilder()
        builder.addInterceptor(ApiInterceptor())

        okhttpClient = builder.build()

        retrofit = Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com")
            .client(okhttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        serviceAPI = retrofit.create(ApiService::class.java)
    }
}