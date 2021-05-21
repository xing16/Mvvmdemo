package com.xing.mvvmdemo.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xing.mvvmdemo.base.Result
import kotlinx.coroutines.launch


class HomeViewModel(private val homeUseCase: HomeUseCase, private val params: String) : ViewModel() {

    private val _homeRepos: MutableLiveData<List<Repo>> = MutableLiveData<List<Repo>>()
    val homeRepos: LiveData<List<Repo>> = _homeRepos

    fun searchHomeRepos(query: String, page: Int, perPage: Int) {
        viewModelScope.launch {
            val result = homeUseCase(HomeRequest(query, page, perPage))
            if (result is Result.Success<List<Repo>>) {
                _homeRepos.value = result.data
            } else {

            }
        }
    }
}