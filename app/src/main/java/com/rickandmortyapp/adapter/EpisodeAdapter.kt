package com.rickandmortyapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.rickandmortyapp.databinding.EpisodeRecyclerRowBinding
import com.rickandmortyapp.model.episodemodel.Resultsssss
import com.rickandmortyapp.view.EpisodeFragmentDirections


class EpisodeAdapter: RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {
    private var episode = emptyList<Resultsssss>()

    class EpisodeViewHolder (private val binding: EpisodeRecyclerRowBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(episodes:Resultsssss){
            binding.episodename1.text=episodes.name
            binding.episodename2.text =episodes.episode
            binding.date.text=episodes.airDate

            itemView.setOnClickListener{
                val action=EpisodeFragmentDirections.actionEpisodeFragmentToEpisodeDetailFragment(episodes = episodes)
                itemView.findNavController().navigate(action)

            }





        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):EpisodeAdapter.EpisodeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = EpisodeRecyclerRowBinding.inflate(layoutInflater,parent,false)
        return EpisodeAdapter.EpisodeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.bind(episode[position])
    }

    override fun getItemCount(): Int {
        return  episode.size

    }

    fun setCharacters(Characterepisode: List<Resultsssss>) {
        episode = Characterepisode
        notifyDataSetChanged()
    }

}




