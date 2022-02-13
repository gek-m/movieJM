package com.interview.moviejm.ui.main.adapter

import androidx.recyclerview.widget.DiffUtil
import com.interview.moviejm.network.domain.ApiMovie

object MovieDiffUtil: DiffUtil.ItemCallback<ApiMovie>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: ApiMovie, newItem: ApiMovie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ApiMovie, newItem: ApiMovie): Boolean {
        return  oldItem == newItem
    }

    override fun getChangePayload(oldItem: ApiMovie, newItem: ApiMovie) = payload
}