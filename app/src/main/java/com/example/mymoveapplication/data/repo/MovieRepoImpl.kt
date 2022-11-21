package com.example.mymoveapplication.data.repo

import com.example.mymoveapplication.data.net.RetrofitServieces
import com.example.mymoveapplication.data.pojo.movie.MovieData
import com.example.mymoveapplication.data.pojo.movie.MovieDetails
import com.example.mymoveapplication.data.pojo.movie.MovieResponse
import com.example.mymoveapplication.data.shared.SharedPreference
import com.example.mymoveapplication.domain.repo.MovieRepo

class MovieRepoImpl(
    private val api: RetrofitServieces,
    private val shared: SharedPreference
) : MovieRepo {

    override suspend fun getMovies(page: Int): List<MovieData> {
        val movieResponse = api.getMovieList(page)
        return movieResponse.results ?: emptyList()
    }

    override suspend fun getMovieDetails(id: String): MovieDetails {
        val movieDetails = api.getCurrentMovie(id)
        return movieDetails
    }

    override suspend fun getResponse(page: Int): MovieResponse {
        val moviePageResponse = api.getMovieList(page)
        return moviePageResponse

    }

    override suspend fun getMovieCommentList(): ArrayList<String> {
        val movieComment = shared.getCommentList()
        return movieComment
    }

    override suspend fun setMovieComment(text: String): String {
        val movieSaveComment = shared.putComment(text)
        return movieSaveComment.toString()
    }

//    override suspend fun getMoveCommentDetails(text: String): MovieDetails {
//        val moveCommentDetails = api.getMoveComment(text)
//        return moveCommentDetails
//    }
}
//
//    override fun getMovieDetails(
//        id: String,
//        callback: (MovieDetails) -> Unit,
//        errorCallback: (Throwable) -> Unit,
//    ) {
//
//
//    }

//val listHardCode = mutableListOf<MoveData>()
//val url =
//            "https://api.themoviedb.org/3/movie/popular?api_key=ebd618f162ffeafbcae3dab64b5aa6a2&language=en-US&page=1&region=US"

//        listHardCode.add(MoveData(R.drawable.image_lief, "Hello", "2000"))
//        listHardCode.add(MoveData(R.drawable.ic_launcher_background, "Hello", "2000"))
//        listHardCode.add(MoveData(R.drawable.ic_launcher_foreground, "Hello", "2000"))
//        listHardCode.add(MoveData(R.drawable.image_lief, "Hello", "2000"))