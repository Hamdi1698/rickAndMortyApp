package com.rickandmortyapp.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rickandmortyapp.model.Character
import com.rickandmortyapp.databinding.CardRecyclerRowBinding
import com.squareup.picasso.Picasso


class CharacterAdapter: RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private var listCharacters = emptyList<Character>()

    class  CharacterViewHolder(private val binding: CardRecyclerRowBinding ):RecyclerView.ViewHolder(binding.root){
   fun bind(character: Character){
        binding.CardName.text = character.name
       binding.CardName2.text = character.species
       Picasso.get().load(character.image).into(binding.cardImage)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CardRecyclerRowBinding.inflate(layoutInflater,parent,false)
        return  CharacterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return  listCharacters.size

    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(listCharacters[position])
        holder.itemView.setOnClickListener {

        }
    }
    fun setCharacters(characters:List<Character>){
        listCharacters = characters
        notifyDataSetChanged()
    }
}