package com.interview.moviejm.ui.movieDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.interview.moviejm.*
import com.interview.moviejm.databinding.MovieDetailsFragmentBinding
import com.interview.moviejm.ui.movieDetails.adapter.CastAdapter
import kotlinx.coroutines.flow.collect

class MovieDetailsFragment : Fragment() {

    companion object {
        private const val ARG_FILM_ID = "argument_film_id"
        fun newInstance(filmId: Int) =
            MovieDetailsFragment().arguments(ARG_FILM_ID to filmId)
    }

    private var filmId: Int = 0

    private val viewModel: MovieDetailsViewModel by activityViewModels()
    private lateinit var binding: MovieDetailsFragmentBinding
    private val adapter = CastAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MovieDetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            arguments?.getInt(ARG_FILM_ID)?.let {
                filmId = it
            }
            viewModel.getMovieDetails(filmId)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.castList.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.movieDetails.collect {
                it?.let {
                    with(binding) {
                        filmTitle.text = it.title
                        filmOverview.text = it.overview
                        filmPosterImage.showWithGlide(it.posterPath)
                        filmMainImage.showWithGlide(it.backdropPath)
                        filmReleasedDate.text = it.releaseDate.toReleasedDate()
                        filmDuration.text = it.runtime.fromMinutesToHHmm()
                        filmGenres.text = it.genres.toNameString()
                    }
                }
            }

        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.movieCast.collect {
                it?.let {
                    adapter.submitList(it.cast)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.loading.collect {
                binding.progressCircular.visibility = if (it) View.VISIBLE else View.GONE
            }
        }
    }
}