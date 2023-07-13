package com.rickandmortyapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rickandmortyapp.R
import com.rickandmortyapp.databinding.FragmentFilterBinding

class FilterFragment : Fragment(R.layout.fragment_filter){
    private  var _binding: FragmentFilterBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFilterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.applyButton.setOnClickListener {
            findNavController().navigate(R.id.action_filterFragment3_to_mainActivity3)

        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }



}