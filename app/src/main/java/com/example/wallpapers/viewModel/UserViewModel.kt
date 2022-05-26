package com.example.wallpapers.viewModel

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.wallpapers.retrofit.ApiClient

class UserViewModel : ViewModel() {
    val liveData = Pager(PagingConfig(pageSize = 2)){
        UserDataSource(ApiClient.apiService)
    }.liveData
}