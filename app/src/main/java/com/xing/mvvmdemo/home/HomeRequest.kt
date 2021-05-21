package com.xing.mvvmdemo.home


data class HomeRequest(
    val query: String,
    val page: Int,
    val perPage: Int
)