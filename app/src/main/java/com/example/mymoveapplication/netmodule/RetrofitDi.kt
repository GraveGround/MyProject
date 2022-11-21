package com.example.mymoveapplication.netmodule

import com.example.mymoveapplication.data.net.RetrofitClient
import okhttp3.Interceptor
import org.koin.dsl.module

val retrofitDi = module {

    factory {
        RetrofitClient.getInterceptor()
    }
    single {
        RetrofitClient.getOkHttpClient(get())
    }
    single {
        RetrofitClient.getClient(get())
    }
}