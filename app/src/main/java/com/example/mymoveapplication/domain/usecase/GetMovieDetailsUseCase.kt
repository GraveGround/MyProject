package com.example.mymoveapplication.domain.usecase

import com.example.mymoveapplication.data.pojo.movie.MovieDetails
import com.example.mymoveapplication.domain.repo.MovieRepo

class GetMovieDetailsUseCase(
    private val moviesRepo: MovieRepo
) {
    suspend fun execute(id: String): MovieDetails {
       return moviesRepo.getMovieDetails(id)
    }
}