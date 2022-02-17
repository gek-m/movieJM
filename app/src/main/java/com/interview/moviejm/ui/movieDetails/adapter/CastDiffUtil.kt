package com.interview.moviejm.ui.movieDetails.adapter

import androidx.recyclerview.widget.DiffUtil
import com.interview.moviejm.network.domain.ApiMovieCast

object CastDiffUtil: DiffUtil.ItemCallback<ApiMovieCast>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: ApiMovieCast, newItem: ApiMovieCast): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ApiMovieCast, newItem: ApiMovieCast): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: ApiMovieCast, newItem: ApiMovieCast) = payload
}