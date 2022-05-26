package com.example.wallpapers.viewModel

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.wallpapers.models.Data
import com.example.recyclerviewpagination.models.UserData
import com.example.wallpapers.retrofit.ApiService

class UserDataSource(var apiService: ApiService):PagingSource<Int, Data>() {
    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        try {
            val nextPageNumber = params.key ?: 1
            val userData:UserData = apiService.getUsers2(nextPageNumber)
            return LoadResult.Page(userData.data,null,nextPageNumber + 1)
        }catch (e:Exception){
            return LoadResult.Error(e)
        }
    }
}