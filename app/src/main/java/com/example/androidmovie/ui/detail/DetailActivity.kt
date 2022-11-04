package com.example.androidmovie.ui.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.androidmovie.R
import com.example.androidmovie.data.source.local.entity.MovieEntity
import com.example.androidmovie.data.source.local.entity.TvShowsEntity
import com.example.androidmovie.databinding.ActivityDetailBinding
import com.example.androidmovie.databinding.ContentDetailMoviesBinding
import com.example.androidmovie.viewmodel.ViewModelFactory
import com.example.androidmovie.vo.Status

class DetailActivity : AppCompatActivity() {

    private lateinit var detailContentBinding: ContentDetailMoviesBinding
    private var menu: Menu? = null
    private lateinit var viewModel: DetailMoviesViewModel
    private lateinit var movieEntity: MovieEntity
    private lateinit var tvShowEntity: TvShowsEntity
    private var origin = ""

    private var _activityDetailBinding: ActivityDetailBinding? = null
    private val activityDetailBinding get() = _activityDetailBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailBinding.detailContent

        setContentView(activityDetailBinding.root)

        setSupportActionBar(activityDetailBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailMoviesViewModel::class.java]
        when (intent.getStringExtra(EXTRA_ORIGIN)) {
            "movies" -> {
                setDetailDataMovies()
                origin = "movies"
            }
            "tvshows" -> {
                setDetailDataTvShows()
                origin = "tvshows"
            }
        }
    }

    private fun setDetailDataMovies() {
        val detailData = intent.getParcelableExtra<MovieEntity>(EXTRA_DATA) as MovieEntity
        activityDetailBinding.progressBar.visibility = View.VISIBLE
        activityDetailBinding.content.visibility = View.INVISIBLE
        val movieId = detailData.movieId
        viewModel.setOrigin("movie")
        viewModel.setSelectedMovies(movieId)
        viewModel.detailMovie.observe(this, { detailMovieEntity ->
            if (detailMovieEntity != null) {
                when (detailMovieEntity.status) {
                    Status.LOADING -> activityDetailBinding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> if (detailMovieEntity.data != null) {
                        movieEntity = detailMovieEntity.data.mMovies
                    }
                    Status.ERROR -> {
                        activityDetailBinding.progressBar.visibility = View.GONE
                        Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        })
        viewModel.getActor(movieId).observe(this, { actor ->
            val actorDb = movieEntity.actor
            if (actorDb == "") {
                viewModel.updateActorMovie(movieEntity, actor)
                activityDetailBinding.progressBar.visibility = View.GONE
                activityDetailBinding.content.visibility = View.VISIBLE
                populateDetailMovie(movieEntity, actor)
            } else {
                activityDetailBinding.progressBar.visibility = View.GONE
                activityDetailBinding.content.visibility = View.VISIBLE
                populateDetailMovie(movieEntity, actorDb)
            }
        })
    }

    private fun populateDetailMovie(mMovies: MovieEntity, actor: String) {
        val txtDateRilis = "Tanggal Rilis ${mMovies.releaseDate}"
        detailContentBinding.textTitle.text = mMovies.title
        detailContentBinding.textDescription.text = mMovies.description
        detailContentBinding.textDate.text = txtDateRilis
        detailContentBinding.textActors.text = actor
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/${mMovies.imagePath}")
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailContentBinding.imagePoster)
        detailContentBinding.btnShare.setOnClickListener {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Bagikan sekarang.")
                .setText("Segera tonton ${mMovies.title} karena bagus lho!")
                .startChooser()
        }

    }

    private fun populateDetailTvShow(tvShowsEntity: TvShowsEntity, actor: String) {
        val txtDateRilis = "Tanggal Rilis ${tvShowsEntity.releaseDate}"
        detailContentBinding.textTitle.text = tvShowsEntity.title
        detailContentBinding.textDescription.text = tvShowsEntity.description
        detailContentBinding.textDate.text = txtDateRilis
        detailContentBinding.textActors.text = actor
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/${tvShowsEntity.imagePath}")
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailContentBinding.imagePoster)
        detailContentBinding.btnShare.setOnClickListener {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Bagikan sekarang.")
                .setText("Segera tonton ${tvShowsEntity.title} karena bagus lho!")
                .startChooser()
        }

    }

    private fun setDetailDataTvShows() {
        val detailData = intent.getParcelableExtra<TvShowsEntity>(EXTRA_DATA) as TvShowsEntity
        val movieId = detailData.movieId
        activityDetailBinding.progressBar.visibility = View.VISIBLE
        activityDetailBinding.content.visibility = View.INVISIBLE
        viewModel.setSelectedMovies(detailData.movieId)
        viewModel.setOrigin("tv")
        viewModel.detailTvShows.observe(this, { detailTvShowEntity ->
            if (detailTvShowEntity != null) {
                when (detailTvShowEntity.status) {
                    Status.LOADING -> activityDetailBinding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> if (detailTvShowEntity.data != null) {
                        tvShowEntity = detailTvShowEntity.data.tvShowsEntity
                    }
                    Status.ERROR -> {
                        activityDetailBinding.progressBar.visibility = View.GONE
                        Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        })
        viewModel.getActor(movieId).observe(this, { actor ->
            val actorDb = tvShowEntity.actor
            if (actorDb == "") {
                viewModel.updateActorTvShow(tvShowEntity, actor)
                activityDetailBinding.progressBar.visibility = View.GONE
                activityDetailBinding.content.visibility = View.VISIBLE
                populateDetailTvShow(tvShowEntity, actor)
            } else {
                activityDetailBinding.progressBar.visibility = View.GONE
                activityDetailBinding.content.visibility = View.VISIBLE
                populateDetailTvShow(tvShowEntity, actorDb)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        when (origin) {
            "movies" -> {
                viewModel.detailMovie.observe(this, { detailMovie ->
                    if (detailMovie != null) {
                        when (detailMovie.status) {
                            Status.LOADING -> activityDetailBinding.progressBar.visibility =
                                View.VISIBLE
                            Status.SUCCESS -> if (detailMovie.data != null) {
                                activityDetailBinding.progressBar.visibility = View.GONE
                                val state = detailMovie.data.mMovies.favorite
                                setFavoriteState(state)
                            }
                            Status.ERROR -> {
                                activityDetailBinding.progressBar.visibility = View.GONE
                                Toast.makeText(
                                    applicationContext,
                                    "Terjadi kesalahan",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                })
            }
            "tvshows" -> {
                viewModel.detailTvShows.observe(this, { detailTvShowEntity ->
                    if (detailTvShowEntity != null) {
                        when (detailTvShowEntity.status) {
                            Status.LOADING -> activityDetailBinding.progressBar.visibility =
                                View.VISIBLE
                            Status.SUCCESS -> if (detailTvShowEntity.data != null) {
                                activityDetailBinding.progressBar.visibility = View.GONE
                                val state = detailTvShowEntity.data.tvShowsEntity.favorite
                                setFavoriteState(state)
                            }
                            Status.ERROR -> {
                                activityDetailBinding.progressBar.visibility = View.GONE
                                Toast.makeText(
                                    applicationContext,
                                    "Terjadi kesalahan",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                })
            }
        }
        return true
    }

    private fun setFavoriteState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_favorite)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_white)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorite) {
            when (origin) {
                "movies" -> {
                    viewModel.setFavoriteMovie()
                }
                "tvshows" -> {
                    viewModel.setFavoriteTvShow()
                }
            }

            return true
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_ORIGIN = "extra_origin"
    }
}