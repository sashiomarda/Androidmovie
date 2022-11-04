package com.example.androidmovie.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.androidmovie.data.source.local.entity.DetailMovieEntity
import com.example.androidmovie.data.source.local.entity.DetailTvShowsEntity
import com.example.androidmovie.data.source.local.entity.MovieEntity
import com.example.androidmovie.data.source.local.entity.TvShowsEntity


@Dao
interface MovieDao {

    @Query("SELECT * FROM movieentities")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieentities where favorite = 1")
    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tvshowsentities where favorite = 1")
    fun getFavoriteTvShow(): DataSource.Factory<Int, TvShowsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(courses: List<MovieEntity>)

    @Query("SELECT * FROM tvshowsentities")
    fun getTvShows(): DataSource.Factory<Int, TvShowsEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(tvShows: List<TvShowsEntity>)

    @Update
    fun updateMovies(movies: MovieEntity)

    @Transaction
    @Query("SELECT * FROM movieentities WHERE movieId = :movieId")
    fun getMovieById(movieId: String): LiveData<DetailMovieEntity>

    @Update
    fun updateMoviesActor(movies: MovieEntity)

    @Update
    fun updateTvShow(tvShow: TvShowsEntity)

    @Transaction
    @Query("SELECT * FROM tvshowsentities WHERE movieId = :tvShowId")
    fun getTvShowById(tvShowId: String): LiveData<DetailTvShowsEntity>

    @Update
    fun updateTvShowsActor(tvShows: TvShowsEntity)

    @Query("SELECT * FROM movieentities WHERE title LIKE '%' || :title || '%'")
    fun findMovieFromDb(title: String): DataSource.Factory<Int, MovieEntity>
}
