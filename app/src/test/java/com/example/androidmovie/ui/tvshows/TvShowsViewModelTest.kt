package com.example.androidmovie.ui.tvshows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.androidmovie.data.source.MovieRepository
import com.example.androidmovie.data.source.local.entity.TvShowsEntity
import com.example.androidmovie.vo.Resource
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowsViewModelTest {

    private lateinit var viewModel: TvShowsViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TvShowsEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<TvShowsEntity>


    @Before
    fun setUp() {
        viewModel = TvShowsViewModel(movieRepository)
    }

    @Test
    fun getTvShows() {
        val dummyTvShows = Resource.success(pagedList)
        `when`(dummyTvShows.data?.size).thenReturn(10)
        val tvShows = MutableLiveData<Resource<PagedList<TvShowsEntity>>>()
        tvShows.value = dummyTvShows

        `when`(movieRepository.getTvShows()).thenReturn(tvShows)
        val tvShowsEntities = viewModel.getTvShows().value?.data
        verify(movieRepository).getTvShows()
        assertNotNull(tvShowsEntities)
        assertEquals(10, tvShowsEntities?.size)

        viewModel.getTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTvShows)
    }

    @get:Rule
    var thrown = ExpectedException.none()

    @Test
    fun emptyDataTvShowsTest() {
        val dummyTvShows = Resource.success(pagedList)
        `when`(dummyTvShows.data?.size).thenReturn(10)
        val tvShows = MutableLiveData<Resource<PagedList<TvShowsEntity>>>()
        tvShows.value = dummyTvShows

        `when`(movieRepository.getTvShows()).thenReturn(tvShows)
        val tvShowsEntities = viewModel.getTvShows().value?.data
        thrown.expect(java.lang.AssertionError::class.java)
        assertNotNull(tvShowsEntities)
        assertEquals(0, tvShowsEntities?.size)
    }
}