package com.rickandmortyapp.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.rickandmortyapp.databinding.LocationRecyclerRowBinding
import com.rickandmortyapp.model.locationmodel.Resultsss
import com.rickandmortyapp.view.LocationFragmentDirections


class LocationAdapter:RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {
    private var locationss = emptyList<Resultsss>()

    class LocationViewHolder (private val binding: LocationRecyclerRowBinding ):RecyclerView.ViewHolder(binding.root){
        fun bind(locationn:Resultsss){
            binding.locationname1.text=locationn.name
            binding.locationname2.text = locationn.type

            itemView.setOnClickListener{view ->
                val action = LocationFragmentDirections.actionLocationFragmentToLocationDetailFragment(locationdetail = locationn)
                view.findNavController().navigate(action)

            }




        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationAdapter.LocationViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = LocationRecyclerRowBinding.inflate(layoutInflater,parent,false)
        return LocationAdapter.LocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
       holder.bind(locationss[position])
    }

    override fun getItemCount(): Int {
        return  locationss.size

    }

    fun setCharacters(characterlocation: List<Resultsss>) {
        locationss = characterlocation
        notifyDataSetChanged()
    }

}

