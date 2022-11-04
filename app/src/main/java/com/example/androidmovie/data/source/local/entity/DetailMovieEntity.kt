package com.example.androidmovie.data.source.local.entity

import androidx.room.Embedded

data class DetailMovieEntity(
    @Embedded
    var mMovies: MovieEntity
)