package com.interview.moviejm.network.domain

import com.google.gson.annotations.SerializedName

data class ApiMovieCast(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("character") val character: String,
    @SerializedName("profile_path") val profilePath: String
)

