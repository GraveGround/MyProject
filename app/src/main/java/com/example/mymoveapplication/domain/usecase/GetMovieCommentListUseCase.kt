package com.example.mymoveapplication.domain.usecase


import com.example.mymoveapplication.domain.repo.MovieRepo

class GetMovieCommentListUseCase(
    private val moviesRepo: MovieRepo
) {

    suspend fun execute(): ArrayList<String> {
        return moviesRepo.getMovieCommentList()
    }

}
