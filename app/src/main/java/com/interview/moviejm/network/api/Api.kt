package com.interview.moviejm.network.api

import com.interview.moviejm.network.domain.ApiCastResult
import com.interview.moviejm.network.domain.ApiMovie
import com.interview.moviejm.network.domain.ApiResult
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("3/discover/movie?api_key=274f828ad283bd634ef4fc1ee4af255f")
    suspend fun getMovieList(): ApiResult

    @GET("3/movie/{movieId}?api_key=274f828ad283bd634ef4fc1ee4af255f")
    suspend fun getMovieDetails(
        @Path("movieId") movieId: Int
    ): ApiMovie

    @GET("3/movie/{movieId}/credits?api_key=274f828ad283bd634ef4fc1ee4af255f")
    suspend fun getMovieCast(
        @Path("movieId") movieId: Int
    ): ApiCastResult
}