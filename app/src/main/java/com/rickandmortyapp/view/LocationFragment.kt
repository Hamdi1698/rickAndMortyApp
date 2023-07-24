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
import com.rickandmortyapp.adapter.LocationAdapter
import com.rickandmortyapp.api.Repository
import com.rickandmortyapp.databinding.FragmentLocationBinding
import com.rickandmortyapp.model.locationmodel.LocationData
import com.rickandmortyapp.viewmodel.SharedViewModel
import com.rickandmortyapp.viewmodel.SharedViewModelFactory
import retrofit2.Response


class LocationFragment : Fragment(R.layout.fragment_location) {
    private  var _binding: FragmentLocationBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels {
        SharedViewModelFactory(Repository())
    }
    private lateinit var adapter :LocationAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)

        sharedViewModel.getLocation(page=1)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLocationBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = LocationAdapter()
        binding.apply {
            sharedViewModel.getLocation.observe(viewLifecycleOwner, Observer { locationResponse: Response<LocationData> ->
                if (locationResponse.isSuccessful) {
                    adapter.setCharacters(locationResponse.body()!!.resultsss)
                    Textim1.visibility = View.GONE
                    CardRecycler1.visibility = View.VISIBLE
                } else {
                    Textim1.text = getString(locationResponse.code())
                    Textim1.visibility = View.GONE
                    CardRecycler1.visibility = View.VISIBLE
                }
            })



            CardRecycler1.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            CardRecycler1.adapter = adapter
            floatingActionButtonLocation.setOnClickListener {
                findNavController().navigate(R.id.action_locationFragment_to_filterFragment)
            }
            binding.toolbar.imageButtonn.setOnClickListener{
                findNavController().navigate(R.id.action_locationFragment_to_menuFragment)
            }
        }

    }


}