package com.xing.mvvmdemo.home

import com.xing.mvvmdemo.http.ApiService
import com.xing.mvvmdemo.http.RetrofitClient


class HomeDataSource {

    suspend fun searchHomeRepos(query: String, page: Int, perPage: Int): HomeData {
        return RetrofitClient.create(ApiService::class.java).searchRepos(query, page, perPage)
    }
}