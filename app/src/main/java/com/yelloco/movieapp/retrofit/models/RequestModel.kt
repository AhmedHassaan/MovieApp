package com.yelloco.movieapp.retrofit.models

import com.google.gson.annotations.SerializedName

data class RequestModel(
    @SerializedName("page")
    val pageNumber: Int,

    @SerializedName("results")
    val resultList: List<MovieModel>,

    @SerializedName("total_pages")
    val totalPages: Int
)
