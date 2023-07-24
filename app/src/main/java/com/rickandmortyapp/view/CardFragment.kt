package com.rickandmortyapp.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.rickandmortyapp.R
import com.rickandmortyapp.adapter.CharacterAdapter
import com.rickandmortyapp.api.Repository
import com.rickandmortyapp.databinding.CardRecyclerRowBinding
import com.rickandmortyapp.databinding.FragmentCardBinding
import com.rickandmortyapp.viewmodel.SharedViewModel
import com.rickandmortyapp.viewmodel.SharedViewModelFactory
import kotlin.properties.Delegates

class CardFragment : Fragment() {

    private var _binding: FragmentCardBinding? = null
    private var sayfa:Int = 1
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels {
        SharedViewModelFactory(Repository())
    }

    private lateinit var adapter: CharacterAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
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
        binding.apply {
        sharedViewModel.resultsCharacters.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                adapter.setCharacters(
                    response.body()!!.results)
                Textim.visibility = View.GONE
                CardRecycler.visibility = View.VISIBLE

            } else {
             Textim.text = getString(response.code())
                Textim.visibility = View.GONE
                CardRecycler.visibility = View.VISIBLE
            }

        })



            CardRecycler.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            CardRecycler.adapter = adapter
            floatingActionButton2.setOnClickListener {
                findNavController().navigate(R.id.action_cardFragment_to_filterFragment)
            }
        }

        sharedViewModel.getCharacters(sayfa)

        binding.toolbar.imageButtonn.setOnClickListener{
          findNavController().navigate(R.id.action_cardFragment_to_menuFragment)
        }




    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
