package com.interview.moviejm.network.datasource

import com.interview.moviejm.network.domain.ApiCastResult
import com.interview.moviejm.network.domain.ApiMovie
import com.interview.moviejm.network.domain.ApiResult

interface MovieDataSource {

    suspend fun getMovies(): ApiResult
    suspend fun getMovie(movieId: Int): ApiMovie
    suspend fun getMovieCast(movieId: Int): ApiCastResult
}