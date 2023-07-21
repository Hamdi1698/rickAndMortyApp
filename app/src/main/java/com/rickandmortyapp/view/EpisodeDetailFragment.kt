package com.rickandmortyapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.rickandmortyapp.R
import com.rickandmortyapp.databinding.FragmentLocationDetailBinding


class EpisodeDetailFragment : Fragment(R.layout.fragment_episode_detail) {
    private  var _binding: FragmentLocationDetailBinding? = null
    private val binding get() = _binding!!
    private val args: EpisodeDetailFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLocationDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val episodess = args.episodes
        binding.apply {
            binding.LocationName.text=episodess.name
            binding.textView3.text=episodess.episode
            binding.textView4.text=episodess.airDate
        }
        binding.backdetaillocation.setOnClickListener {
            findNavController().navigate(R.id.action_episodeDetailFragment_to_episodeFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}