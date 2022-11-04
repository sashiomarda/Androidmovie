package com.example.androidmovie.ui.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.androidmovie.data.source.MovieRepository
import com.example.androidmovie.data.source.local.entity.TvShowsEntity
import com.example.androidmovie.vo.Resource

class TvShowsViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getTvShows(): LiveData<Resource<PagedList<TvShowsEntity>>> = movieRepository.getTvShows()

    fun getFavorite(): LiveData<PagedList<TvShowsEntity>> = movieRepository.getFavoriteTvShow()
}

