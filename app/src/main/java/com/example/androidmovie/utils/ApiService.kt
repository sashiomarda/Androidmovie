package com.example.androidmovie.utils

import com.example.androidmovie.data.source.remote.response.ActorResponse
import com.example.androidmovie.data.source.remote.response.MovieApiResponse
import retrofit2.Call
import retrofit2.http.*


interface ApiService {
    @GET("3/discover/movie")
    fun getMovies(
        @Query("api_key") api_key: String?,
        @Query("language") language: String?,
        @Query("sort_by") sort_by: String?,
        @Query("page") page: String?
    ): Call<MovieApiResponse>

    @GET("3/{origin}/{movie_id}/credits")
    fun getActors(
        @Path("origin") origin: String?,
        @Path("movie_id") movie_id: String?,
        @Query("api_key") api_key: String?
    ): Call<ActorResponse>

    @GET("3/discover/tv")
    fun getTvShows(
        @Query("api_key") api_key: String?,
        @Query("language") language: String?,
        @Query("sort_by") sort_by: String?,
        @Query("page") page: String?
    ): Call<MovieApiResponse>

}