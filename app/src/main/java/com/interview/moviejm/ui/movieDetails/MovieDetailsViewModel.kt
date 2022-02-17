package com.interview.moviejm.ui.movieDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.interview.moviejm.network.domain.ApiCastResult
import com.interview.moviejm.network.domain.ApiMovie
import com.interview.moviejm.network.domain.ApiMovieCast
import com.interview.moviejm.network.movie.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlin.Error

class MovieDetailsViewModel : ViewModel() {

    private val _loading = MutableStateFlow(false)
    private val _error = MutableStateFlow<String?>(null)
    private val _movieDetails = MutableStateFlow<ApiMovie?>(null)
    private val _movieCast = MutableStateFlow<ApiCastResult?>(null)

    private val repository: ApiMovieRepository = ApiMovieRepositoryFactory.create()

    val loading: Flow<Boolean> = _loading
    val error: Flow<String?> = _error
    val movieDetails: Flow<ApiMovie?> = _movieDetails
    val movieCast: Flow<ApiCastResult?> = _movieCast

    fun getMovieDetails(movieId: Int) {
        _loading.value = true
        getApiMovieDetails(movieId)
        getApiMovieCast(movieId)
        _loading.value = false
    }

    private fun getApiMovieDetails(movieId: Int) {
        viewModelScope.launch {
            when (val response = repository.getMovie(movieId)) {
                is Success -> {
                    _movieDetails.value = response.value
                    _error.value = null
                }
                is Error -> _error.emit("Can't load movie details data")
            }
        }
    }

    private fun getApiMovieCast(movieId: Int) {
        viewModelScope.launch {
            when(val response = repository.getMovieCast(movieId)) {
                is Success -> {
                    _movieCast.value = response.value
                    _error.value = null
                }
                is Error -> _error.emit("Can't load movie cast data")
            }
        }
    }
}