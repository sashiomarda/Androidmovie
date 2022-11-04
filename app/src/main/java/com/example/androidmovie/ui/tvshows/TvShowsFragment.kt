package com.example.androidmovie.ui.tvshows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidmovie.databinding.FragmentTvshowsBinding
import com.example.androidmovie.viewmodel.ViewModelFactory
import com.example.androidmovie.vo.Status

class TvShowsFragment(private val originActivity: String) : Fragment() {

    private var _fragmentTvshowsBinding: FragmentTvshowsBinding? = null
    private val fragmentMoviesBinding get() = _fragmentTvshowsBinding!!
    private lateinit var viewModel: TvShowsViewModel
    private lateinit var tvShowsAdapter: TvShowsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _fragmentTvshowsBinding = FragmentTvshowsBinding.inflate(inflater, container, false)
        return fragmentMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[TvShowsViewModel::class.java]
            tvShowsAdapter = TvShowsAdapter()
            when (originActivity) {
                "MainActivity" -> {
                    populateMain()
                }
                "FavoriteActivity" -> {
                    populateFavorite()
                }
            }

        }
    }

    private fun populateFavorite() {
        viewModel.getFavorite().observe(this, { favorite ->
            fragmentMoviesBinding.progressBar.visibility = View.GONE
            tvShowsAdapter.submitList(favorite)
        })
        with(fragmentMoviesBinding.rvTvshows) {
            this.layoutManager = LinearLayoutManager(context)
            this.setHasFixedSize(true)
            this.adapter = tvShowsAdapter
        }
    }

    private fun populateMain() {
        viewModel.getTvShows().observe(this, { tvShows ->
            if (tvShows != null) {
                when (tvShows.status) {
                    Status.LOADING -> fragmentMoviesBinding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        fragmentMoviesBinding.progressBar.visibility = View.GONE
                        tvShowsAdapter.submitList(tvShows.data)
                    }
                    Status.ERROR -> {
                        fragmentMoviesBinding.progressBar.visibility = View.GONE
                        Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        with(fragmentMoviesBinding.rvTvshows) {
            this.layoutManager = LinearLayoutManager(context)
            this.setHasFixedSize(true)
            this.adapter = tvShowsAdapter
        }
    }

}

