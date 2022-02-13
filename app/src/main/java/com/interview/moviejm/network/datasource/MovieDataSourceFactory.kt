package com.interview.moviejm.network.datasource

import com.interview.moviejm.network.api.ApiFactory

object MovieDataSourceFactory {

    fun create(): MovieDataSource = CloudMovieDataSource(ApiFactory.create())
}