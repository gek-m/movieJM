package com.interview.moviejm.network.domain

import com.google.gson.annotations.SerializedName

data class ApiMovie(

    @SerializedName("id") val id: Int,
    @SerializedName("original_title") val title: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("backdrop_path") val backdropPath: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("runtime") val runtime: Int,
    @SerializedName("genres") val genres: List<ApiGenres>
)
