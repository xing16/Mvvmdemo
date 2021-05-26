package com.xing.mvvmdemo.wan

import com.xing.mvvmdemo.http.ApiService
import com.xing.mvvmdemo.http.RetrofitClient
import com.xing.mvvmdemo.http.Response

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
class WanRemoteDataSource {

    suspend fun getArticles(page: Int): Response<ArticleData> {
        return RetrofitClient.create(ApiService::class.java).getArticles(page)
    }
}