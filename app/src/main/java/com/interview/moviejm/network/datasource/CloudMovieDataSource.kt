package com.interview.moviejm.network.datasource

import com.interview.moviejm.network.api.Api
import com.interview.moviejm.network.domain.ApiCastResult
import com.interview.moviejm.network.domain.ApiMovie
import com.interview.moviejm.network.domain.ApiResult

class CloudMovieDataSource(private val api: Api): MovieDataSource {
    override suspend fun getMovies(): ApiResult =
        api.getMovieList()

    override suspend fun getMovie(movieId: Int): ApiMovie =
        api.getMovieDetails(movieId)

    override suspend fun getMovieCast(movieId: Int): ApiCastResult =
        api.getMovieCast(movieId)

}