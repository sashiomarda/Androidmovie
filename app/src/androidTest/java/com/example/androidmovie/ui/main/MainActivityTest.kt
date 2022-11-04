package com.example.androidmovie.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.androidmovie.R
import com.example.androidmovie.utils.DataMoviesDummy
import com.example.androidmovie.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityTest {

    private val dummyMovies = DataMoviesDummy.generateMovies()
    private val dummyTvShows = DataMoviesDummy.generateTvShows()

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.rv_movies))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun loadDetailMovies() {
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        onView(withId(R.id.text_title))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_date))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.image_poster))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_actors))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_description))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.btn_share))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.action_favorite))
            .perform(ViewActions.click())
    }

    @Test
    fun loadTvShows() {
        onView(withText("TV Shows")).perform(ViewActions.click())
        onView(withId(R.id.rv_tvshows))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.rv_tvshows))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShows.size))
    }

    @Test
    fun loadDetailTvShows() {
        onView(withText("TV Shows")).perform(ViewActions.click())
        onView(withId(R.id.rv_tvshows))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.rv_tvshows))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
        onView(withId(R.id.rv_tvshows)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        onView(withId(R.id.text_title))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_date))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.image_poster))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_actors))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_description))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.btn_share))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.action_favorite))
            .perform(ViewActions.click())
    }

    @Test
    fun loadFavoriteMovie() {
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        onView(withId(R.id.action_favorite)).perform(ViewActions.click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.action_favorite)).perform(ViewActions.click())
        onView(withId(R.id.rv_movies)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        onView(withId(R.id.text_title))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_date))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.image_poster))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_actors))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_description))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.btn_share))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.action_favorite)).perform(ViewActions.click())
        onView(isRoot()).perform(ViewActions.pressBack())
    }

    @Test
    fun loadFavoriteTvShow() {
        onView(withText("TV Shows")).perform(ViewActions.click())
        onView(withId(R.id.rv_tvshows)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        onView(withId(R.id.action_favorite)).perform(ViewActions.click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withText("TV Shows")).perform(ViewActions.click())
        onView(withId(R.id.action_favorite)).perform(ViewActions.click())
        onView(withText("TV Shows")).perform(ViewActions.click())
        onView(withId(R.id.rv_tvshows)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.rv_tvshows)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        onView(withId(R.id.text_title))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_date))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.image_poster))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_actors))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_description))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.btn_share))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.action_favorite)).perform(ViewActions.click())
        onView(isRoot()).perform(ViewActions.pressBack())
    }
}