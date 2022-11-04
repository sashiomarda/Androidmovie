package com.example.androidmovie.data.source


import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.androidmovie.data.source.local.entity.DetailMovieEntity
import com.example.androidmovie.data.source.local.entity.DetailTvShowsEntity
import com.example.androidmovie.data.source.local.entity.MovieEntity
import com.example.androidmovie.data.source.local.entity.TvShowsEntity
import com.example.androidmovie.vo.Resource

interface MovieDataSource {

    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getTvShows(): LiveData<Resource<PagedList<TvShowsEntity>>>

    fun getActor(movieId: String, origin: String): LiveData<String>

    fun getDetailMovie(movieId: String): LiveData<Resource<DetailMovieEntity>>

    fun updateActorMovie(movie: MovieEntity, actor: String)

    fun getDetailTvShow(tvShowId: String): LiveData<Resource<DetailTvShowsEntity>>

    fun updateActorTvShow(tvShow: TvShowsEntity, actor: String)

    fun setFavoriteMovie(movie: MovieEntity, state: Boolean)

    fun setFavoriteTvShow(movie: TvShowsEntity, state: Boolean)

    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>>

    fun getFavoriteTvShow(): LiveData<PagedList<TvShowsEntity>>
}