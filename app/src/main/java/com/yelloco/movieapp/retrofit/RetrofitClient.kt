package com.yelloco.movieapp.retrofit

import com.yelloco.movieapp.enums.Constants
import com.yelloco.movieapp.retrofit.models.RequestModel
import retrofit2.Call
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

    fun getPopularMovies() : Call<RequestModel>
    {
        return retrofit.getPopularMovies()
    }

    fun getNowPlayingMovies() : Call<RequestModel>
    {
        return retrofit.getNowPlayingMovies()
    }

    fun getTopRatedMovies() : Call<RequestModel>
    {
        return retrofit.getTopRatedMovies()
    }

    fun getUpcomingMovies() : Call<RequestModel>
    {
        return retrofit.getUpcomingMovies()
    }
}