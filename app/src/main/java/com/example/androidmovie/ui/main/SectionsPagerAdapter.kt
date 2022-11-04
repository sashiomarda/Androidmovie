package com.example.androidmovie.ui.main

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

import com.example.androidmovie.R
import com.example.androidmovie.ui.movies.MoviesFragment
import com.example.androidmovie.ui.tvshows.TvShowsFragment


class SectionsPagerAdapter(
    private val mContext: Context,
    fm: FragmentManager,
    private val originActivity: String
) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private var query = ""

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movies, R.string.tv_shows)
    }

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> MoviesFragment(originActivity, query, false)
            1 -> TvShowsFragment(originActivity)
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence =
        mContext.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = 2
}