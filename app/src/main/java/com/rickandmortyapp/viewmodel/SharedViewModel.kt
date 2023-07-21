package com.rickandmortyapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.rickandmortyapp.api.Repository
import com.rickandmortyapp.model.TestResponse
import com.rickandmortyapp.model.episodemodel.EpisodeModel
import com.rickandmortyapp.model.locationmodel.LocationData
import com.rickandmortyapp.paging.CharacterPagingSource
import kotlinx.coroutines.launch
import retrofit2.Response

class SharedViewModel(private val repository: Repository) : ViewModel() {
    var getLocation = MutableLiveData<Response<LocationData>>()
    var resultsCharacters = MutableLiveData<Response<TestResponse>>()
    var filterValue = MutableLiveData<Array<Int>>()
    var isFilter = MutableLiveData<Boolean>()
    val loaading = MutableLiveData<Boolean>()
    var getEpisodes =MutableLiveData<Response<EpisodeModel>>()

    val characterList = Pager(PagingConfig(1)) {
        CharacterPagingSource(repository)
    }.flow.cachedIn(viewModelScope)

    init {
        filterValue.value = arrayOf(0, 0)
        isFilter.value = false
        loaading.postValue(false)
    }

    fun getCharacters(page: Int) {
        viewModelScope.launch {
            val characters = repository.getCharacters(page)
            resultsCharacters.value = characters
        }
    }
    fun testByStatusAndGender(status:String,gender:String,page: Int){
        viewModelScope.launch {
            val characters =repository.testByStatusAndGender(status, gender, page)
            resultsCharacters.value = characters
        }
    }
    fun testByStatus(status:String,page: Int){
        viewModelScope.launch {
            val characters =repository.testByStatus(status,page)
            resultsCharacters.value = characters
        }
    }
    fun testByGender(gender:String,page: Int){
        viewModelScope.launch {
            val characters =repository.testByGender( gender, page)
            resultsCharacters.value = characters
        }
    }
    fun getLocation(page: Int){
        viewModelScope.launch {
            val locations =repository.getLocation(page)
            getLocation.value =locations
        }
    }
    fun getEpisodes(page: Int){
        viewModelScope.launch {
            val episodes=repository.getEpisode(page)
            getEpisodes.value = episodes
        }
    }

}