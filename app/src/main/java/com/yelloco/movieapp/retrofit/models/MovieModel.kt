package com.yelloco.movieapp.retrofit.models

import com.google.gson.annotations.SerializedName

data class MovieModel(
    @SerializedName("title")
    val name: String,

    @SerializedName("backdrop_path")
    val backImage: String,

    @SerializedName("poster_path")
    val posterImage: String,

    @SerializedName("release_date")
    val releaseDate: String
)
