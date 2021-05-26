package com.xing.mvvmdemo.wan

import kotlinx.coroutines.flow.Flow
import com.xing.mvvmdemo.http.Result

/**
 *
 * @ProjectName: mvvmdemo
 * @Description: 作用描述 <todo>
 * @Author: xinxing.tao
 * @CreateDate: 2021/5/26 10:02
 * @UpdateUser: xinxing.tao
 * @UpdateDate: 2021/5/26 10:02
 * @UpdateRemark: 无
 */
interface IWanRepository {

    suspend fun getArticle(page: Int): Flow<Result<ArticleData>>
}