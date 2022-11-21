package com.example.mymoveapplication.data.pojo.movie

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieDetails(

    @SerializedName("adult")
    val adult: Boolean? = null,

    @SerializedName("backdrop_path")
    val backdropPath: String? = null,

//    @SerializedName("belongs_to_collection")
//    val belongsToCollection: String? = null,

    @SerializedName("budget")
    val budget: Int? = null,

    @SerializedName("homepage")
    val homepage: String? = null,

    @SerializedName("id")
    val id: String? = null,

    @SerializedName("imdb_id")
    val imdId: String? = null,

    @SerializedName("original_language")
    val originalLanguage: String? = null,

    @SerializedName("original_title")
    val originalTitle: String? = null,

    @SerializedName("overview")
    val overview: String? = null,

    @SerializedName("popularity")
    val popularity: Double? = null,

    @SerializedName("poster_path")
    val posterPath: String? = null,

    @SerializedName("release_date")
    val releaseDate: String? = null,

    @SerializedName("revenue")
    val revenue: Int? = null,

    @SerializedName("runtime")
    val runtime: Int? = null,

    @SerializedName("status")
    val status: String? = null,

    @SerializedName("tagline")
    val tagline: String? = null,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("video")
    val video: Boolean? = null,

    @SerializedName("vote_average")
    val voteAverage: Double? = null,

    @SerializedName("vote_count")
    val voteCount: Int? = null,


    @SerializedName("comments")
    val comments: String? = null


) : Serializable


//    @SerializedName("production_companies")
//    val productionCompanies: Array<String>? = null,


//    @SerializedName("spoken_languages")
//    val spokenLanguages: Array<String>? = null,


//    @SerializedName("genres")
//    val genres: Array<String>? = null,