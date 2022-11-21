package com.example.mymoveapplication.di

import android.content.SharedPreferences
import com.example.mymoveapplication.data.db.noteRepository.NoteRealisation
import com.example.mymoveapplication.data.db.noteRepository.NoteRepository
import com.example.mymoveapplication.data.repo.MovieRepoImpl
import com.example.mymoveapplication.data.shared.SharedPreference
import com.example.mymoveapplication.domain.repo.MovieRepo
import org.koin.dsl.module

val dataDi = module {

    single<MovieRepo> {
        MovieRepoImpl(get())
    }
    single<SharedPreferences> {
        SharedPreference(get())
    }
    single<NoteRepository> {
        NoteRealisation(get())
    }


}