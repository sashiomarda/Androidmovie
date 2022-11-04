package com.example.androidmovie.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidmovie.R
import com.example.androidmovie.databinding.ActivityFavoriteBinding
import com.example.androidmovie.ui.main.SectionsPagerAdapter

class FavoriteActivity : AppCompatActivity() {

    private val originActivity = FavoriteActivity::class.java.simpleName
    private var _activityFavoriteBinding: ActivityFavoriteBinding? = null
    private val activityFavoriteBinding get() = _activityFavoriteBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _activityFavoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(activityFavoriteBinding.root)
        supportActionBar?.title = getString(R.string.favorite)

        val sectionsPagerAdapter =
            SectionsPagerAdapter(this, supportFragmentManager, originActivity)
        activityFavoriteBinding.viewPagerFav.adapter = sectionsPagerAdapter
        activityFavoriteBinding.tabsFav.setupWithViewPager(activityFavoriteBinding.viewPagerFav)

        supportActionBar?.elevation = 0f
    }
}