package com.interview.moviejm.network.domain

import com.google.gson.annotations.SerializedName

data class ApiGenres(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)