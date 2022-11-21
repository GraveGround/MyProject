package com.example.mymoveapplication.data.net

import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url
            .newBuilder()
            .addQueryParameter("api_key", "ebd618f162ffeafbcae3dab64b5aa6a2")
            .build()
        request = request.newBuilder().url(url).build()

        return chain.proceed(request)
    }
}