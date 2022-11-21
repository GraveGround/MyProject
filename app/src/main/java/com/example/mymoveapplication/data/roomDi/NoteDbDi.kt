package com.example.mymoveapplication.data.roomDi

import androidx.room.Room
import com.example.mymoveapplication.R
import com.example.mymoveapplication.data.db.noteDb.NoteDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val noteDbDi = module {
    single<NoteDataBase> {
        Room.databaseBuilder(
            androidContext(),
            NoteDataBase::class.java, "database-name"
        ).build()
    }

}