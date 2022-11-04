package com.example.androidmovie.ui.tvshows

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.androidmovie.R
import com.example.androidmovie.data.source.local.entity.TvShowsEntity
import com.example.androidmovie.databinding.ItemsMoviesBinding
import com.example.androidmovie.ui.detail.DetailActivity

class TvShowsAdapter :
    PagedListAdapter<TvShowsEntity, TvShowsAdapter.CourseViewHolder>(TvShowsAdapter.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val itemsMoviesBinding =
            ItemsMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(itemsMoviesBinding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow)
        }
    }

    inner class CourseViewHolder(private val binding: ItemsMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: TvShowsEntity) {
            with(binding) {
                tvItemTitleMain.text = movie.title
                tvDescriptionMain.text = movie.description
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_ORIGIN, "tvshows")
                    intent.putExtra(DetailActivity.EXTRA_DATA, movie)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500/${movie.imagePath}")
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowsEntity>() {
            override fun areItemsTheSame(oldItem: TvShowsEntity, newItem: TvShowsEntity): Boolean {
                return oldItem.movieId == newItem.movieId
            }

            override fun areContentsTheSame(
                oldItem: TvShowsEntity,
                newItem: TvShowsEntity
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
