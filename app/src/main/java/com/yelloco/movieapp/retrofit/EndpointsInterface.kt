package com.yelloco.movieapp.retrofit

import com.yelloco.movieapp.enums.Constants
import com.yelloco.movieapp.retrofit.models.RequestModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EndpointsInterface {

    private val lang : String
        get() = "en-US"

    @GET("popular")
    fun getPopularMovies(@Query("api_key") apiKey: String = Constants.API_KEY.constant,
                         @Query("language") lang: String = this.lang) : Call<RequestModel>

    @GET("top_rated")
    fun getTopRatedMovies(@Query("api_key") apiKey: String = Constants.API_KEY.constant,
                         @Query("language") lang: String = this.lang) : Call<RequestModel>

    @GET("upcoming")
    fun getUpcomingMovies(@Query("api_key") apiKey: String = Constants.API_KEY.constant,
                         @Query("language") lang: String = this.lang) : Call<RequestModel>

    @GET("now_playing")
    fun getNowPlayingMovies(@Query("api_key") apiKey: String = Constants.API_KEY.constant,
                         @Query("language") lang: String = this.lang) : Call<RequestModel>
}