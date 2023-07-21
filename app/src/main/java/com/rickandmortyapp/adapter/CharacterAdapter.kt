package com.rickandmortyapp.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.rickandmortyapp.databinding.CardRecyclerRowBinding
import com.rickandmortyapp.model.Results

import com.rickandmortyapp.view.CardFragmentDirections
import com.squareup.picasso.Picasso


class CharacterAdapter: RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {



    private var resultsCharacter = emptyList<Results>()


    class  CharacterViewHolder(private val binding: CardRecyclerRowBinding ):RecyclerView.ViewHolder(binding.root){
   fun bind(result: Results){
       binding.CardName.text = result.name
       binding.CardName2.text = result.species
       Picasso.get().load(result.image).into(binding.cardimage)

       itemView.setOnClickListener{view ->
           val action =CardFragmentDirections.actionCardFragmentToCardDetailFragment(characterss = result)
           view.findNavController().navigate(action)

       }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CardRecyclerRowBinding.inflate(layoutInflater,parent,false)
        return  CharacterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return  resultsCharacter.size

    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(resultsCharacter[position])

    }
    fun setCharacters(characters:List<Results>){
        resultsCharacter = characters
        notifyDataSetChanged()
    }
}