package com.xing.mvvmdemo.base

import java.net.ConnectException
import java.net.UnknownHostException


open class BaseRepository {

    suspend inline fun <reified T : Any> execute(noinline block: suspend () -> Response<T>): Result<T> {
        return try {
            val response = block()
            if (response.errorCode == 0) {
                Result.Success(response.data)
            } else {
                Result.Error(ApiException(response as Response<Nothing>))
            }
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }


    suspend inline fun <reified T : Any> request(
        crossinline block: suspend () -> Response<T>,
        noinline onSuccess: ((T?) -> Unit)? = null,
        noinline onError: ((Exception) -> Unit)? = null,
        noinline onComplete: (() -> Unit)? = null
    ) {
        try {
            val result = block()
            onSuccess?.invoke(result.data)
        } catch (ex: Exception) {
            ex.printStackTrace()
            when (ex) {
                is UnknownHostException -> {
                }
                is ConnectException -> {

                }
                else -> {

                }
            }
            onError?.invoke(ex)
        } finally {
            onComplete?.invoke()
        }
    }


}