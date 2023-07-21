package com.rickandmortyapp.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.rickandmortyapp.api.Repository
import com.rickandmortyapp.model.Results


class CharacterPagingSource(private val repository: Repository): PagingSource<Int, Results>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Results> {
        return try {
            val currentPage = params.key ?: 1
            val response = repository.getCharacters(currentPage)
            val data = response.body()!!.results
            val responseData = mutableListOf<Results>()
            responseData.addAll(data)


            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, Results>): Int? {
        return null
    }

}




