package com.interview.moviejm.network.movie

import com.interview.moviejm.network.datasource.MovieDataSource
import com.interview.moviejm.network.domain.ApiCastResult
import com.interview.moviejm.network.domain.ApiMovie
import com.interview.moviejm.network.domain.ApiResult

class ApiMovieRepositoryImpl(private val cloud: MovieDataSource): ApiMovieRepository {
    override suspend fun getMovies(): RepositoryResult<ApiResult> =
        Success(cloud.getMovies())

    override suspend fun getMovie(movieId: Int): RepositoryResult<ApiMovie> =
        Success(cloud.getMovie(movieId))

    override suspend fun getMovieCast(movieId: Int): RepositoryResult<ApiCastResult> =
        Success(cloud.getMovieCast(movieId))
}

sealed class RepositoryResult<T>

data class Success<T>(val value: T) : RepositoryResult<T>()

data class Error<T>(val value: Throwable) : RepositoryResult<T>()