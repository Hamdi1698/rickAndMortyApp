package com.rickandmortyapp.model

import android.os.Parcelable
import com.rickandmortyapp.model.Character
import kotlinx.parcelize.Parcelize


data class CharacterList(
    var results:List<Character>
)