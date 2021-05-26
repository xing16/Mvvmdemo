package com.xing.mvvmdemo.wan

import com.xing.mvvmdemo.common.FlowUseCase
import com.xing.mvvmdemo.http.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

/**
 *
 * @ProjectName: mvvmdemo
 * @Description: 作用描述 <todo>
 * @Author: xinxing.tao
 * @CreateDate: 2021/5/24 10:17
 * @UpdateUser: xinxing.tao
 * @UpdateDate: 2021/5/24 10:17
 * @UpdateRemark: 无
 */
class WanUseCase(dispatcher: CoroutineDispatcher) : FlowUseCase<WanRequest, ArticleData>(dispatcher) {

    override suspend fun execute(parameters: WanRequest): Flow<Result<ArticleData>> = WanRepositoryImpl(WanRemoteDataSource(), null).getArticle(parameters.page)
}