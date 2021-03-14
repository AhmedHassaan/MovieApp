package com.yelloco.movieapp.retrofit

import com.yelloco.movieapp.enums.Constants
import com.yelloco.movieapp.retrofit.models.RequestModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL.constant)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val API: EndpointsInterface by lazy {
        retrofit.create(EndpointsInterface::class.java)
    }

    fun getPopularMovies() : RequestModel
    {
        return API.getPopularMovies()
    }

    fun getNowPlayingMovies() : RequestModel
    {
        return API.getNowPlayingMovies()
    }

    fun getTopRatedMovies() : RequestModel
    {
        return API.getTopRatedMovies()
    }

    fun getUpcomingMovies() : RequestModel
    {
        return API.getUpcomingMovies()
    }
}