package com.example.mymoveapplication.koinstart

import android.app.Application
import com.example.mymoveapplication.data.roomDi.noteDbDi
import com.example.mymoveapplication.di.dataDi
import com.example.mymoveapplication.di.domainDi
import com.example.mymoveapplication.di.uiViewModelCreate
import com.example.mymoveapplication.netmodule.retrofitDi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class AppKoinStarter : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(listOf(uiViewModelCreate, domainDi, dataDi, retrofitDi, noteDbDi))
            androidContext(this@AppKoinStarter)
        }
    }
}