package com.interview.moviejm

import android.view.View
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.interview.moviejm.network.domain.ApiGenres
import java.util.concurrent.TimeUnit

const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w342"
const val RELEASED_DATE = "Released: "

fun View.click(click: () -> Unit) = setOnClickListener { click() }

fun Fragment.arguments(vararg arguments: Pair<String, Any>): Fragment {
    this.arguments = bundleOf(*arguments)
    return this
}

fun String.toApiImageUrl(): String = IMAGE_BASE_URL + this

fun String.toReleasedDate(): String = RELEASED_DATE + this

fun Int.fromMinutesToHHmm(): String {
    val hours = TimeUnit.MINUTES.toHours(this.toLong())
    val remainMinutes = this - TimeUnit.HOURS.toMinutes(hours)
    return "$hours"+"h $remainMinutes"+ "m"
}

fun List<ApiGenres>.toNameString(): String =
    this.joinToString { g -> g.name }

fun ImageView.showWithGlide(url: String?) {
    url?.let {
        Glide.with(this)
            .load(url.toApiImageUrl())
            .into(this)
    }
}