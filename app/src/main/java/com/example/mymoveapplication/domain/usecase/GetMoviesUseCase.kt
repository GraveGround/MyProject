package com.example.mymoveapplication.domain.usecase

import com.example.mymoveapplication.data.pojo.movie.MovieData
import com.example.mymoveapplication.domain.repo.MovieRepo

class GetMoviesUseCase(
    private val moviesRepo: MovieRepo
) {

    suspend fun execute(page: Int): List<MovieData> {
        return moviesRepo.getMovies(page)
    }
}