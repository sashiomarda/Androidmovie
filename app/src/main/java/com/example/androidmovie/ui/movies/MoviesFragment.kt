package com.example.androidmovie.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidmovie.databinding.FragmentMoviesBinding
import com.example.androidmovie.viewmodel.ViewModelFactory
import com.example.androidmovie.vo.Status

class MoviesFragment(
    private val originActivity: String, private val query: String,
    private var isFindMovie: Boolean
) : Fragment() {

    private var _fragmentMoviesBinding: FragmentMoviesBinding? = null
    private val fragmentMoviesBinding get() = _fragmentMoviesBinding!!
    private lateinit var viewModel: MoviesViewModel
    private lateinit var academyAdapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _fragmentMoviesBinding = FragmentMoviesBinding.inflate(inflater, container, false)
        return fragmentMoviesBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[MoviesViewModel::class.java]
            academyAdapter = MoviesAdapter()
            when (originActivity) {
                "MainActivity" -> {
//                        populateFindMovie("")
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
            academyAdapter.submitList(favorite)
        })
        with(fragmentMoviesBinding.rvMovies) {
            this.layoutManager = LinearLayoutManager(context)
            this.setHasFixedSize(true)
            this.adapter = academyAdapter
        }
    }

    private fun populateMain() {
        viewModel.getMovies().observe(this, { movies ->
            if (movies != null) {
                when (movies.status) {
                    Status.LOADING -> fragmentMoviesBinding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        fragmentMoviesBinding.progressBar.visibility = View.GONE
                        academyAdapter.submitList(movies.data)
                    }
                    Status.ERROR -> {
                        fragmentMoviesBinding.progressBar.visibility = View.GONE
                        Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        with(fragmentMoviesBinding.rvMovies) {
            this.layoutManager = LinearLayoutManager(context)
            this.setHasFixedSize(true)
            this.adapter = academyAdapter
        }
    }
}

