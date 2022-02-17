package com.interview.moviejm.ui.movieDetails

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class MovieDetailsScreen(private val movieId: Int): FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        MovieDetailsFragment.newInstance(movieId)
}