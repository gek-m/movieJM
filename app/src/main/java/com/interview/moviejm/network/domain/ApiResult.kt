package com.interview.moviejm.network.domain

import com.google.gson.annotations.SerializedName

data class ApiResult(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: List<ApiMovie>
)
