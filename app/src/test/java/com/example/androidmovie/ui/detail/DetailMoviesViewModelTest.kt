package com.example.androidmovie.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.androidmovie.data.source.MovieRepository
import com.example.androidmovie.utils.DataMoviesDummy
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
class DetailMoviesViewModelTest {

    private lateinit var viewModel: DetailMoviesViewModel
    private val dummyMovie = DataMoviesDummy.generateMovies()[0]
    private val movieId = dummyMovie.movieId
    private val dummyActor = DataMoviesDummy.generateActor()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var movieObserver: Observer<String>

    @Before
    fun setUp() {
        viewModel = DetailMoviesViewModel(movieRepository)
        viewModel.setSelectedMovies(movieId)
        viewModel.setOrigin("movie")
    }

    @Test
    fun getActor() {
        val actor = MutableLiveData<String>()
        actor.value = dummyActor
        `when`(movieRepository.getActor(movieId, "movie")).thenReturn(actor)
        val movieActor = viewModel.getActor(movieId).value as String
        verify(movieRepository).getActor(movieId, "movie")
        assertNotNull(movieActor)
        assertEquals(dummyActor[0], movieActor[0])
        viewModel.getActor(movieId).observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyActor)
    }

    @get:Rule
    var thrown = ExpectedException.none()

    @Test
    fun emptyActorTest() {
        val actor = MutableLiveData<String>()
        actor.value = dummyActor
        val movieActor = ""
        thrown.expect(java.lang.AssertionError::class.java)
        assertNotNull(movieActor)
        assertEquals(dummyActor.length, movieActor.length)
    }
}