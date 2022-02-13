package com.interview.moviejm.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.interview.moviejm.databinding.MainFragmentBinding
import com.interview.moviejm.network.domain.ApiMovie
import com.interview.moviejm.ui.main.adapter.MoviesAdapter
import kotlinx.coroutines.flow.collect

class MainFragment : Fragment(), MoviesAdapter.Delegate {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: MainFragmentBinding
    private val adapter = MoviesAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            viewModel.getMovieResults()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            moviesList.adapter = adapter
            moviesList.layoutManager = GridLayoutManager(requireContext(), 2)
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.results.collect {
                adapter.submitList(it?.results)
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.loading.collect {
                binding.progressCircular.visibility = if (it) View.VISIBLE else View.GONE
            }
        }
    }

    override fun onMovieSelect(movie: ApiMovie) {
        viewModel.showMovieDetails(movie.id)
    }
}