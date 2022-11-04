package com.example.androidmovie.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.androidmovie.data.source.MovieRepository

import com.example.androidmovie.data.source.local.entity.MovieEntity
import com.example.androidmovie.vo.Resource

class MoviesViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> = movieRepository.getAllMovies()

    fun getFavorite(): LiveData<PagedList<MovieEntity>> = movieRepository.getFavoriteMovie()

}
