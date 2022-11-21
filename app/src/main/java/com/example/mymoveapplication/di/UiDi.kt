package com.example.mymoveapplication.di

import com.example.mymoveapplication.ui.main.CustomDialogViewModel
import com.example.mymoveapplication.ui.main.MovieDetailsViewModel
import com.example.mymoveapplication.ui.main.MovieListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiViewModelCreate = module {

    viewModel<MovieListViewModel> {

        MovieListViewModel(
            getMoviesUseCase = get(),
            getMovieResponseUseCase = get()
        )
    }

    viewModel<MovieDetailsViewModel> {

        MovieDetailsViewModel(
            getMovieDetailsUseCase = get(),
            getMovieCommentListUseCase = get(),
            getMovieSaveCommentUseCase = get()
        )

    }
//    viewModel<CustomDialogViewModel> {
//
//        CustomDialogViewModel(
//            getNoteRepoUseCase = get()
//        )
//    }



}