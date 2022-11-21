package com.example.mymoveapplication.domain.usecase

import com.example.mymoveapplication.domain.repo.MovieRepo

class GetMovieSaveCommentUseCase(
    private val moviesRepo: MovieRepo
) {

    suspend fun execute(text: String): String {
        return moviesRepo.setMovieComment(text)
    }

}