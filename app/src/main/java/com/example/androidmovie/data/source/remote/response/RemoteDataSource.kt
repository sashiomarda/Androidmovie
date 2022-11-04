package com.example.androidmovie.data.source.remote.response

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidmovie.BuildConfig
import com.example.androidmovie.data.source.remote.ApiResponse
import com.example.androidmovie.utils.ApiConfig
import com.example.androidmovie.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.StringBuilder
import java.util.ArrayList

class RemoteDataSource private constructor() {

    private val apiKey = BuildConfig.KEY
    private val TAG = "RemoteDataSource"

    companion object {

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                RemoteDataSource().apply { instance = this }
            }
    }

    fun getAllMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        val list = ArrayList<MovieResponse>()
        val client = ApiConfig.getApiService().getMovies(
            apiKey, "en-US", "popularity.desc", "1"
        )
        client.enqueue(object : Callback<MovieApiResponse> {
            override fun onResponse(
                call: Call<MovieApiResponse>,
                response: Response<MovieApiResponse>
            ) {
                if (response.isSuccessful) {
                    val responseObject = response.body()
                    val listArray = responseObject?.results
                    if (!listArray.isNullOrEmpty()) {
                        for (i in listArray.indices) {
                            val movies = listArray[i]
                            Log.e(TAG, movies.toString())
                            val id = movies.id
                            val title = movies.title
                            val description = movies.overview
                            val date = movies.releaseDate
                            val imagePath = movies.posterPath
                            val movieResponse =
                                MovieResponse(id.toString(), title, description, date, imagePath)
                            list.add(movieResponse)
                        }
                        resultMovie.value = ApiResponse.success(list)
                    }
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieApiResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
                EspressoIdlingResource.decrement()
            }
        })
        return resultMovie
    }

    fun getAllTvShows(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultTvShow = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        val list = ArrayList<MovieResponse>()
        val client = ApiConfig.getApiService().getTvShows(
            apiKey, "en-US", "popularity.desc", "1"
        )
        client.enqueue(object : Callback<MovieApiResponse> {
            override fun onResponse(
                call: Call<MovieApiResponse>,
                response: Response<MovieApiResponse>
            ) {
                if (response.isSuccessful) {
                    val responseObject = response.body()
                    val listArray = responseObject?.results
                    if (!listArray.isNullOrEmpty()) {
                        for (i in listArray.indices) {
                            val tvShows = listArray[i]
                            Log.e(TAG, tvShows.toString())
                            val id = tvShows.id
                            val title = tvShows.name
                            val description = tvShows.overview
                            val date = tvShows.firstAirDate
                            val imagePath = tvShows.posterPath
                            val movieResponse =
                                MovieResponse(id.toString(), title, description, date, imagePath)
                            list.add(movieResponse)
                        }
                        resultTvShow.value = ApiResponse.success(list)
                    }
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieApiResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
                EspressoIdlingResource.decrement()
            }
        })
        return resultTvShow
    }

    fun getActor(callback: LoadActorCallback, movieId: String, origin: String) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getActors(origin, movieId, apiKey)
        client.enqueue(object : Callback<ActorResponse> {
            override fun onResponse(
                call: Call<ActorResponse>,
                response: Response<ActorResponse>
            ) {
                if (response.isSuccessful) {
                    val responseObject = response.body()
                    val listResponse = responseObject?.cast
                    if (!listResponse.isNullOrEmpty()) {
                        val actorSb = StringBuilder()
                        for (i in listResponse.indices) {
                            if (i < 5) {
                                actorSb.append(listResponse[i].name).append(",")
                            }
                        }
                        val actor = actorSb.toString()
                        callback.onActorReceived(actor)
                    }
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<ActorResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
                EspressoIdlingResource.decrement()
            }
        })
    }


    fun getActorById(courseId: String): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultModules = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        return resultModules
    }

    interface LoadActorCallback {
        fun onActorReceived(resultsItem: String)
    }

}

