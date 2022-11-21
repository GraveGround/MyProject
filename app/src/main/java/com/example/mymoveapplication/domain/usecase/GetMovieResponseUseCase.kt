package com.example.mymoveapplication.domain.usecase

import com.example.mymoveapplication.data.pojo.movie.MovieData
import com.example.mymoveapplication.data.pojo.movie.MovieResponse
import com.example.mymoveapplication.domain.repo.MovieRepo

class GetMovieResponseUseCase(
    private val moviesRepo: MovieRepo
) {
    suspend fun execute(page: Int): MovieResponse {
        return moviesRepo.getResponse(page)
    }
}