package com.interview.moviejm.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.interview.moviejm.R
import com.interview.moviejm.network.domain.ApiMovie

class MoviesAdapter(private val delegate: Delegate?) :
    ListAdapter<ApiMovie, MovieViewHolder>(MovieDiffUtil) {

    interface Delegate {
        fun onMovieSelect(movie: ApiMovie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_movie, parent, false)
        )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) =
        holder.bind(getItem(position), delegate)
}