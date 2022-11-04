package com.example.androidmovie.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.androidmovie.data.source.local.LocalDataSource
import com.example.androidmovie.data.source.local.entity.DetailMovieEntity
import com.example.androidmovie.data.source.local.entity.DetailTvShowsEntity
import com.example.androidmovie.data.source.local.entity.MovieEntity
import com.example.androidmovie.data.source.local.entity.TvShowsEntity
import com.example.androidmovie.data.source.remote.response.MovieResponse
import com.example.androidmovie.data.source.remote.response.RemoteDataSource
import com.example.androidmovie.utils.AppExecutors
import com.example.androidmovie.utils.DataMoviesDummy
import com.example.androidmovie.utils.LiveDataTestUtil
import com.example.androidmovie.utils.PagedListUtil
import com.example.androidmovie.vo.Resource
import org.junit.Assert.*
import org.junit.Rule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.eq

import org.junit.Test
import org.mockito.Mockito.*

class MovieRepositoryTest {

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val academyRepository = FakeMovieRepository(remote, local,appExecutors)

    private val moviesDummyEntity = DataMoviesDummy.generateMovies()
    private val movieId = moviesDummyEntity[0].movieId
    private val moviesResponses = ArrayList<MovieResponse>()
    private val tvShowsDummyEntity = DataMoviesDummy.generateTvShows()
    private val tvShowId = tvShowsDummyEntity[0].movieId
    private val tvShowsResponses = ArrayList<MovieResponse>()
    private val actorResponses = DataMoviesDummy.generateActor()
    private val origin = "movie"


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun getAllMovies() {
        for (i in moviesDummyEntity.indices) {
            val movieResponse = MovieResponse(
                moviesDummyEntity[i].movieId,
                moviesDummyEntity[i].title,
                moviesDummyEntity[i].description,
                moviesDummyEntity[i].releaseDate,
                moviesDummyEntity[i].imagePath
            )
            moviesResponses.add(movieResponse)
        }

        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        academyRepository.getAllMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataMoviesDummy.generateMovies()))
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(moviesResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteMovie() {
        for (i in moviesDummyEntity.indices) {
            val movieResponse = MovieResponse(
                moviesDummyEntity[i].movieId,
                moviesDummyEntity[i].title,
                moviesDummyEntity[i].description,
                moviesDummyEntity[i].releaseDate,
                moviesDummyEntity[i].imagePath
            )
            moviesResponses.add(movieResponse)
        }
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovie()).thenReturn(dataSourceFactory)
        academyRepository.getFavoriteMovie()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataMoviesDummy.generateMovies()))
        com.nhaarman.mockitokotlin2.verify(local).getFavoriteMovie()
        assertNotNull(movieEntities)
        assertEquals(moviesResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteTvShow() {
        for (i in tvShowsDummyEntity.indices) {
            val movieResponse = MovieResponse(
                tvShowsDummyEntity[i].movieId,
                tvShowsDummyEntity[i].title,
                tvShowsDummyEntity[i].description,
                tvShowsDummyEntity[i].releaseDate,
                tvShowsDummyEntity[i].imagePath
            )
            tvShowsResponses.add(movieResponse)
        }
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowsEntity>
        `when`(local.getFavoriteTvShow()).thenReturn(dataSourceFactory)
        academyRepository.getFavoriteTvShow()

        val tvShowsEntities = Resource.success(PagedListUtil.mockPagedList(DataMoviesDummy.generateTvShows()))
        com.nhaarman.mockitokotlin2.verify(local).getFavoriteTvShow()
        assertNotNull(tvShowsEntities)
        assertEquals(tvShowsResponses.size.toLong(), tvShowsEntities.data?.size?.toLong())
    }

    @Test
    fun getTvShows() {
        for (i in tvShowsDummyEntity.indices) {
            val tvShowsResponse = MovieResponse(
                tvShowsDummyEntity[i].movieId,
                tvShowsDummyEntity[i].title,
                tvShowsDummyEntity[i].description,
                tvShowsDummyEntity[i].releaseDate,
                tvShowsDummyEntity[i].imagePath
            )
            tvShowsResponses.add(tvShowsResponse)
        }
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowsEntity>
        `when`(local.getTvShows()).thenReturn(dataSourceFactory)
        academyRepository.getTvShows()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataMoviesDummy.generateTvShows()))
        verify(local).getTvShows()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShowsResponses.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getActor() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadActorCallback)
                .onActorReceived(actorResponses)
            null
        }.`when`(remote).getActor(any(), eq(movieId), eq(origin))
        val actor = LiveDataTestUtil.getValue(academyRepository.getActor(movieId, origin))
        verify(remote).getActor(any(), eq(movieId), eq(origin))
        assertNotNull(actor)
        assertEquals(actorResponses.length, actor.length)
    }

    @Test
    fun getDetailMovie() {
        for (i in moviesDummyEntity.indices) {
            val movieResponse = MovieResponse(
                moviesDummyEntity[i].movieId,
                moviesDummyEntity[i].title,
                moviesDummyEntity[i].description,
                moviesDummyEntity[i].releaseDate,
                moviesDummyEntity[i].imagePath
            )
            moviesResponses.add(movieResponse)
        }
        val dummyDetailMovieEntity = MutableLiveData<DetailMovieEntity>()
        dummyDetailMovieEntity.value = DataMoviesDummy.generateDummyMovieDetail()
        `when`(local.getDetailMovie(movieId)).thenReturn(dummyDetailMovieEntity)

        val MovieEntities = LiveDataTestUtil.getValue(academyRepository.getDetailMovie(movieId))
        com.nhaarman.mockitokotlin2.verify(local).getDetailMovie(movieId)
        assertNotNull(MovieEntities.data)
        assertNotNull(MovieEntities.data?.mMovies?.title)
        assertEquals(moviesResponses[0].title, MovieEntities.data?.mMovies?.title)
    }

    @Test
    fun getDetailTvShow() {
        for (i in tvShowsDummyEntity.indices) {
            val tvShowResponse = MovieResponse(
                tvShowsDummyEntity[i].movieId,
                tvShowsDummyEntity[i].title,
                tvShowsDummyEntity[i].description,
                tvShowsDummyEntity[i].releaseDate,
                tvShowsDummyEntity[i].imagePath
            )
            tvShowsResponses.add(tvShowResponse)
        }
        val dummyDetailTvShowEntity = MutableLiveData<DetailTvShowsEntity>()
        dummyDetailTvShowEntity.value = DataMoviesDummy.generateDummyTvShowDetail()
        `when`(local.getDetailTvShow(tvShowId)).thenReturn(dummyDetailTvShowEntity)

        val tvShowEntities = LiveDataTestUtil.getValue(academyRepository.getDetailTvShow(tvShowId))
        com.nhaarman.mockitokotlin2.verify(local).getDetailTvShow(tvShowId)
        assertNotNull(tvShowEntities.data)
        assertNotNull(tvShowEntities.data?.tvShowsEntity?.title)
        assertEquals(tvShowsResponses[0].title, tvShowEntities.data?.tvShowsEntity?.title)
    }

}