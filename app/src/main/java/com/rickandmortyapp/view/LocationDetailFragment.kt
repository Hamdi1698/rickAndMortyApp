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

class LocationDetailFragment : Fragment() {
    private  var _binding: FragmentLocationDetailBinding? = null
    private val binding get() = _binding!!
    private val args: LocationDetailFragmentArgs by navArgs()

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
        val locations = args.locationdetail

        binding.apply {
            TypeName.text=locations.type
            DimesionName.text=locations.dimension
            LocationName.text=locations.name
        }
        binding.backdetaillocation.setOnClickListener {
            findNavController().navigate(R.id.action_locationDetailFragment_to_locationFragment)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}