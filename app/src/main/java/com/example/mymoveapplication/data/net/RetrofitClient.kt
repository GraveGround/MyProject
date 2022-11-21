package com.example.mymoveapplication.data.net

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://api.themoviedb.org/3/"

    fun getInterceptor(): Interceptor = MyInterceptor()

    fun getOkHttpClient(interceptor: Interceptor) =
        OkHttpClient.Builder().addInterceptor(interceptor).build()

    fun getClient(okHttpClient: OkHttpClient): RetrofitServieces =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitServieces::class.java)

}
