package com.example.androidmovie.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.example.androidmovie.data.source.local.entity.DetailMovieEntity
import com.example.androidmovie.data.source.local.entity.DetailTvShowsEntity
import com.example.androidmovie.data.source.local.entity.MovieEntity
import com.example.androidmovie.data.source.local.entity.TvShowsEntity
import com.example.androidmovie.data.source.local.room.MovieDao

class LocalDataSource private constructor(private val movieDao: MovieDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieDao).apply {
                INSTANCE = this
            }
    }

    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = movieDao.getMovies()

    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity> = movieDao.getFavoriteMovie()

    fun getFavoriteTvShow(): DataSource.Factory<Int, TvShowsEntity> = movieDao.getFavoriteTvShow()

    fun insertMovies(movies: List<MovieEntity>) = movieDao.insertMovies(movies)

    fun getTvShows(): DataSource.Factory<Int, TvShowsEntity> = movieDao.getTvShows()

    fun insertTvShows(tvShows: List<TvShowsEntity>) = movieDao.insertTvShows(tvShows)

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.favorite = newState
        movieDao.updateMovies(movie)
    }

    fun getDetailMovie(movieId: String): LiveData<DetailMovieEntity> =
        movieDao.getMovieById(movieId)

    fun setFavoriteTShow(tvShows: TvShowsEntity, newState: Boolean) {
        tvShows.favorite = newState
        movieDao.updateTvShow(tvShows)
    }

    fun updateActorMovieDb(movie: MovieEntity, actor: String) {
        movie.actor = actor
        movieDao.updateMoviesActor(movie)
    }

    fun getDetailTvShow(tvShowId: String): LiveData<DetailTvShowsEntity> =
        movieDao.getTvShowById(tvShowId)

    fun updateActorTvShowDb(tvShow: TvShowsEntity, actor: String) {
        tvShow.actor = actor
        movieDao.updateTvShowsActor(tvShow)
    }
}