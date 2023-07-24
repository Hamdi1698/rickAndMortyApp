package com.rickandmortyapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rickandmortyapp.R
import com.rickandmortyapp.databinding.FragmentMenuBinding


class MenuFragment : Fragment(R.layout.fragment_menu) {
    private  var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textView5.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_cardFragment)
        }
        binding.textView6.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_locationFragment)
        }
        binding.textView7.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_episodeFragment)
        }
        binding.toolbar.imageButtonnn.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_cardFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}