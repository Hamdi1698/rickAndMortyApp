package com.rickandmortyapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rickandmortyapp.databinding.EpisodeRecyclerRowBinding
import com.rickandmortyapp.model.episodemodel.Result


class EpisodeAdapter: RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {
    private var episode = emptyList<Result>()

    class EpisodeViewHolder (private val binding: EpisodeRecyclerRowBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(episodes:Result){
            binding.episodename1.text=episodes.name
            binding.episodename2.text =episodes.episode
            binding.date.text=episodes.airDate






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

    fun setCharacters(Characterepisode: List<Result>) {
        episode = Characterepisode
        notifyDataSetChanged()
    }

}




