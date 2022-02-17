package com.interview.moviejm.ui.main.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.interview.moviejm.click
import com.interview.moviejm.databinding.ViewMovieBinding
import com.interview.moviejm.network.domain.ApiMovie
import com.interview.moviejm.showWithGlide

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding: ViewMovieBinding by viewBinding()

    fun bind(movie: ApiMovie, delegate: MoviesAdapter.Delegate?) {
        with(binding) {
            movieTitle.text = movie.title
            movieReleaseDate.text = movie.releaseDate
            movieImage.showWithGlide(movie.posterPath)
            root.click {
                delegate?.onMovieSelect(movie)
            }
        }
    }
}
