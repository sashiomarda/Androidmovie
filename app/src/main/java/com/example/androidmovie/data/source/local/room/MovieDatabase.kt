package com.example.androidmovie.data.source.local.room

import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.example.androidmovie.data.source.local.entity.MovieEntity
import com.example.androidmovie.data.source.local.entity.TvShowsEntity

@Database(entities = [MovieEntity::class, TvShowsEntity::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {

        @Volatile
        private var INSTANCE: MovieDatabase? = null

        fun getInstance(context: Context): MovieDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    MovieDatabase::class.java,
                    "Movie.db"
                ).build().apply {
                    INSTANCE = this
                }
            }
    }
}