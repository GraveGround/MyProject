package com.example.mymoveapplication.domain.repo

import com.example.mymoveapplication.data.pojo.movie.MovieData
import com.example.mymoveapplication.data.pojo.movie.MovieDetails
import com.example.mymoveapplication.data.pojo.movie.MovieResponse

interface MovieRepo {
    suspend fun getMovies(page: Int):List<MovieData>
    suspend fun getMovieDetails(id:String):MovieDetails
    suspend fun getResponse(page: Int):MovieResponse

    suspend fun getMovieCommentList(): ArrayList<String>
    suspend fun setMovieComment(text: String): String
}
