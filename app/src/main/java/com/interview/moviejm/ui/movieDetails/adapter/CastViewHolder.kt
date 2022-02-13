package com.interview.moviejm.ui.movieDetails.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.interview.moviejm.databinding.ViewCastBinding
import com.interview.moviejm.network.domain.ApiMovieCast
import com.interview.moviejm.showWithGlide

class CastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding: ViewCastBinding by viewBinding()

    fun bind(cast: ApiMovieCast) {
        with(binding){
            actorName.text = cast.name
            actorCharacter.text = cast.character
            actorImage.showWithGlide(cast.profilePath)
        }
    }
}