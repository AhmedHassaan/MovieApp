package com.yelloco.movieapp.retrofit

import com.yelloco.movieapp.enums.Constants
import com.yelloco.movieapp.retrofit.models.RequestModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val retrofit: EndpointsInterface by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL.constant)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EndpointsInterface::class.java)
    }

    fun getPopularMovies() : RequestModel
    {
        return retrofit.getPopularMovies()
    }

    fun getNowPlayingMovies() : RequestModel
    {
        return retrofit.getNowPlayingMovies()
    }

    fun getTopRatedMovies() : RequestModel
    {
        return retrofit.getTopRatedMovies()
    }

    fun getUpcomingMovies() : RequestModel
    {
        return retrofit.getUpcomingMovies()
    }
}