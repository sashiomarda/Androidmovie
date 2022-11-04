package com.example.androidmovie.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.androidmovie.data.source.MovieRepository
import com.example.androidmovie.data.source.local.entity.DetailMovieEntity
import com.example.androidmovie.data.source.local.entity.DetailTvShowsEntity
import com.example.androidmovie.data.source.local.entity.MovieEntity
import com.example.androidmovie.data.source.local.entity.TvShowsEntity
import com.example.androidmovie.vo.Resource

class DetailMoviesViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    private var movieId = MutableLiveData<String>()
    private lateinit var origin: String

    fun setSelectedMovies(movieId: String) {
        this.movieId.value = movieId
    }

    var detailMovie: LiveData<Resource<DetailMovieEntity>> =
        Transformations.switchMap(movieId) { mMovieId ->
            movieRepository.getDetailMovie(mMovieId)
        }

    fun setOrigin(origin: String) {
        this.origin = origin
    }

    fun getActor(movieIdActor: String): LiveData<String> =
        movieRepository.getActor(movieIdActor, origin)

    fun setFavoriteMovie() {
        val detailMovie = detailMovie.value
        if (detailMovie != null) {
            val movie = detailMovie.data

            if (movie != null) {
                val movieEntity = movie.mMovies
                val newState = !movieEntity.favorite
                movieRepository.setFavoriteMovie(movieEntity, newState)
            }
        }
    }

    fun setFavoriteTvShow() {
        val detailTvShow = detailTvShows.value
        if (detailTvShow != null) {
            val tvShow = detailTvShow.data
            if (tvShow != null) {
                val tvShowEntity = tvShow.tvShowsEntity
                val newState = !tvShowEntity.favorite
                movieRepository.setFavoriteTvShow(tvShowEntity, newState)
            }
        }
    }

    fun updateActorMovie(movieEntity: MovieEntity, actor: String) {
        movieRepository.updateActorMovie(movieEntity, actor)
    }

    var detailTvShows: LiveData<Resource<DetailTvShowsEntity>> =
        Transformations.switchMap(movieId) { mTvshowId ->
            movieRepository.getDetailTvShow(mTvshowId)
        }

    fun updateActorTvShow(tvShowsEntity: TvShowsEntity, actor: String) {
        movieRepository.updateActorTvShow(tvShowsEntity, actor)
    }
}


