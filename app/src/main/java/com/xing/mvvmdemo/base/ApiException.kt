package com.xing.mvvmdemo.base


data class ApiException(val response: Response<Nothing>) : Exception()
