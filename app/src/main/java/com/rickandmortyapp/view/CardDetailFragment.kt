package com.rickandmortyapp.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.rickandmortyapp.R
import com.rickandmortyapp.databinding.FragmentCardDetailBinding
import com.squareup.picasso.Picasso


class CardDetailFragment : Fragment(R.layout.fragment_card_detail) {
    private  var _binding: FragmentCardDetailBinding? = null
    private val binding get() = _binding!!
    private val args: CardDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCardDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val character = args.characterss

        binding.apply {
            Nametext.text = character.name
            Statustext.text = character.status
            Speciestext.text = character.species
            Gendertext.text = character.gender
            Picasso.get().load(character.image).into(detailImage)
            OriginName.text = character.origin.name
            EpisodesItem.text =character.episode.getOrNull(character.id)

/*
            if (character.type ==""){
                Typetext.text = getString(R.string.Not_Found)
            }else{
                Typetext.text = character.type
            }

 */
            when {
                character.type.isEmpty() -> Typetext.text = getString(R.string.Not_Found)
                else -> Typetext.text = character.type
            }

            Locationtext.text = character.location.name
            EpisodesItem.text = character.episode.getOrNull(7)

        }

        binding.backk.setOnClickListener {
            findNavController().navigate(R.id.action_cardDetailFragment_to_mainActivity)
        }
        binding.locationgo.setOnClickListener {
            findNavController().navigate(R.id.action_cardDetailFragment_to_locationFragment)
        }
        binding.episode.setOnClickListener {
            findNavController().navigate(R.id.action_cardDetailFragment_to_episodeFragment)
        }


        }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}

