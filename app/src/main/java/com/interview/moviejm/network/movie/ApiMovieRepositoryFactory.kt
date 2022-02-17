package com.interview.moviejm.network.movie

import com.interview.moviejm.network.datasource.MovieDataSourceFactory

object ApiMovieRepositoryFactory {

    fun create(): ApiMovieRepository =
        ApiMovieRepositoryImpl(
            MovieDataSourceFactory.create()
        )
}