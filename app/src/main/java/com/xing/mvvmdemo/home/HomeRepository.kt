package com.xing.mvvmdemo.home


class HomeRepository(private val homeDataSource: HomeDataSource) {

    suspend fun searchHomeRepos(query: String, page: Int, perPage: Int): HomeData {
        return homeDataSource.searchHomeRepos(query, page, perPage)
    }
}