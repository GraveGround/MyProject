package com.example.mymoveapplication.di

import com.example.mymoveapplication.domain.usecase.*
import org.koin.dsl.module


val domainDi = module {

    factory<GetMovieDetailsUseCase> {
        GetMovieDetailsUseCase(
            moviesRepo = get()
        )
    }
    factory<GetMoviesUseCase> {
        GetMoviesUseCase(
            moviesRepo = get()
        )
    }
    factory<GetMovieResponseUseCase> {
        GetMovieResponseUseCase(
            moviesRepo = get()
        )
    }
    factory<GetNoteRepoUseCase> {

        GetNoteRepoUseCase(
            noteRepo = get()
        )
    }
    factory<GetMovieCommentListUseCase> {
        GetMovieCommentListUseCase(
            moviesRepo = get()
        )
    }
    factory<GetMovieSaveCommentUseCase> {
        GetMovieSaveCommentUseCase(
            moviesRepo = get()
        )
    }
}
