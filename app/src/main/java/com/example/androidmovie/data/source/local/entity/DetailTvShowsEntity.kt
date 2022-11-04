package com.example.androidmovie.data.source.local.entity

import androidx.room.Embedded

data class DetailTvShowsEntity(
    @Embedded
    var tvShowsEntity: TvShowsEntity
)