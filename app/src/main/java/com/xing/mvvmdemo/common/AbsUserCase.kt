package com.xing.mvvmdemo.common

import com.xing.mvvmdemo.http.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext


abstract class AbsUserCase<in P, R>(private val dispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(parameters: P): Result<R> {
        return try {
            withContext(dispatcher) {
                execute(parameters).let {
                    Result.Success(it)
                }
            }
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }


    protected abstract suspend fun execute(params: P): R
}