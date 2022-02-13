package com.interview.moviejm.network.movie

import com.interview.moviejm.network.domain.ApiCastResult
import com.interview.moviejm.network.domain.ApiMovie
import com.interview.moviejm.network.domain.ApiResult


interface ApiMovieRepository {

    suspend fun getMovies(): RepositoryResult<ApiResult>
    suspend fun getMovie(movieId: Int): RepositoryResult<ApiMovie>
    suspend fun getMovieCast(movieId: Int): RepositoryResult<ApiCastResult>
}