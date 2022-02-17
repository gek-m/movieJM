package com.interview.moviejm.network.domain

import com.google.gson.annotations.SerializedName

data class ApiCastResult(
    @SerializedName("id") val id: Int,
    @SerializedName("cast") val cast: List<ApiMovieCast>
)
