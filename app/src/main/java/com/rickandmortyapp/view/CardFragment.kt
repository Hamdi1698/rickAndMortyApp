package com.rickandmortyapp.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.adapters.CardViewBindingAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.rickandmortyapp.R
import com.rickandmortyapp.adapter.CharacterAdapter
import com.rickandmortyapp.api.Repository
import com.rickandmortyapp.databinding.FragmentCardBinding
import com.rickandmortyapp.viewmodel.SharedViewModel
import com.rickandmortyapp.viewmodel.SharedViewModelFactory

class CardFragment : Fragment() {

    private var _binding: FragmentCardBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels {
        SharedViewModelFactory(Repository())
    }

    private lateinit var adapter: CharacterAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedViewModel.getCharacters(1)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CharacterAdapter()

        sharedViewModel.listCharacters.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                Log.d("Result", response.body()?.results.toString())

            } else {
                Log.d("Results Error", response.code().toString())
            }

        })

        binding.apply {
            CardRecycler.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            CardRecycler.adapter = adapter
            floatingActionButton2.setOnClickListener {
                findNavController().navigate(R.id.action_cardFragment_to_filterFragment3)
            }
        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
