package com.xing.mvvmdemo.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

/**
 *
 * @ProjectName: mvvmdemo
 * @Description: 作用描述 <todo>
 * @Author: xinxing.tao
 * @CreateDate: 2021/5/21 17:26
 * @UpdateUser: xinxing.tao
 * @UpdateDate: 2021/5/21 17:26
 * @UpdateRemark: 无
 */
abstract class FlowUseCase<in P, R>(private val dispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(parameters: P): Flow<Result<R>> {
        return execute(parameters)
            .catch { exception ->
                emit(Result.Error(Exception(exception)))
            }.flowOn(dispatcher)
    }

    abstract suspend fun execute(parameters: P): Flow<Result<R>>
}