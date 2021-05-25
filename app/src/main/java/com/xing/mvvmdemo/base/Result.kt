package com.xing.mvvmdemo.base


sealed class Result<out R> {
    data class Success<out R>(val data: R) : Result<R>()
    data class Error(val exception: Exception) : Result<Nothing>()
    object Loading : Result<Nothing>()
}

val Result<*>.succeeded
    get() = this is Result.Success && data != null

val <T> Result<T>.data: T?
    get() = (this as? Result.Success)?.data
