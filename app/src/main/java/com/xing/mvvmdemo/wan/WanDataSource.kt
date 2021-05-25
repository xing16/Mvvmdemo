package com.xing.mvvmdemo.wan

import com.xing.mvvmdemo.ApiService
import com.xing.mvvmdemo.RetrofitClient
import com.xing.mvvmdemo.base.Response
import kotlinx.coroutines.flow.Flow

/**
 *
 * @ProjectName: mvvmdemo
 * @Description: 作用描述 <todo>
 * @Author: xinxing.tao
 * @CreateDate: 2021/5/24 10:29
 * @UpdateUser: xinxing.tao
 * @UpdateDate: 2021/5/24 10:29
 * @UpdateRemark: 无
 */
class WanDataSource {

    suspend fun getArticles(page: Int): Response<ArticleData> {
        return RetrofitClient.create(ApiService::class.java).getArticles(page)
    }
}