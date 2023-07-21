package com.rickandmortyapp.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.rickandmortyapp.R
import com.rickandmortyapp.adapter.EpisodeAdapter
import com.rickandmortyapp.api.Repository
import com.rickandmortyapp.databinding.CardRecyclerRowBinding
import com.rickandmortyapp.databinding.FragmentCardBinding
import com.rickandmortyapp.databinding.FragmentEpisodeBinding
import com.rickandmortyapp.model.episodemodel.EpisodeModel
import com.rickandmortyapp.model.locationmodel.LocationData
import com.rickandmortyapp.viewmodel.SharedViewModel
import com.rickandmortyapp.viewmodel.SharedViewModelFactory
import retrofit2.Response


class EpisodeFragment : Fragment(R.layout.fragment_episode) {
    private var _binding: FragmentEpisodeBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModels: SharedViewModel by activityViewModels {
        SharedViewModelFactory(Repository())}
    private var adapter =EpisodeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedViewModels.getEpisodes(page = 1)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEpisodeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter =EpisodeAdapter()
        binding.apply { sharedViewModels.getEpisodes.observe(viewLifecycleOwner, Observer { episodeResponse: Response<EpisodeModel> ->
            if (episodeResponse.isSuccessful) {
                adapter.setCharacters(episodeResponse.body()!!.results)
                Textim2.visibility = View.GONE
                CardRecycler2.visibility = View.VISIBLE
            } else {
                Textim2.text = getString(episodeResponse.code())
                Textim2.visibility = View.GONE
                CardRecycler2.visibility = View.VISIBLE
            }
        })



            CardRecycler2.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            CardRecycler2.adapter = adapter

        }

    }

}