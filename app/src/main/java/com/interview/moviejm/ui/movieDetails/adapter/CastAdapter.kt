package com.interview.moviejm.ui.movieDetails.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.interview.moviejm.R
import com.interview.moviejm.network.domain.ApiMovieCast

class CastAdapter :
    ListAdapter<ApiMovieCast, CastViewHolder>(CastDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder =
        CastViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_cast, parent, false)
        )

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) =
        holder.bind(getItem(position))
}