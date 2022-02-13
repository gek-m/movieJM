package com.interview.moviejm.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.interview.moviejm.App.Navigation.router
import com.interview.moviejm.network.domain.ApiResult
import com.interview.moviejm.network.movie.*
import com.interview.moviejm.ui.movieDetails.MovieDetailsScreen
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _loading = MutableStateFlow(false)
    private val _error = MutableStateFlow<String?>(null)
    private val _results = MutableStateFlow<ApiResult?>(null)

    private val repository: ApiMovieRepository = ApiMovieRepositoryFactory.create()

    val loading: Flow<Boolean> = _loading
    val error: Flow<String?> = _error
    val results: Flow<ApiResult?> = _results

    fun getMovieResults() {
        _loading.value = true
        viewModelScope.launch {
            when (val response = repository.getMovies()) {
                is Success<*> -> {
                    _results.value = response.value as ApiResult?
                    _error.value = null
                }
                is Error -> _error.emit("Can't load data")
            }
            _loading.value = false
        }
    }

    fun showMovieDetails(movieId: Int) {
        router.navigateTo(MovieDetailsScreen(movieId))
    }
}