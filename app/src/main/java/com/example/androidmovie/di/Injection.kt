package com.example.androidmovie.di

import android.content.Context
import com.example.androidmovie.data.source.MovieRepository
import com.example.androidmovie.data.source.local.LocalDataSource
import com.example.androidmovie.data.source.local.room.MovieDatabase
import com.example.androidmovie.data.source.remote.response.RemoteDataSource
import com.example.androidmovie.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): MovieRepository {

        val database = MovieDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.movieDao())
        val appExecutors = AppExecutors()

        return MovieRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}
