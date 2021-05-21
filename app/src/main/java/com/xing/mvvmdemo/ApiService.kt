package com.xing.mvvmdemo

import com.xing.mvvmdemo.home.HomeData
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *
 * @ProjectName: mvvmdemo
 * @Description: 作用描述 <todo>
 * @Author: xinxing.tao
 * @CreateDate: 2021/4/13 9:41
 * @UpdateUser: xinxing.tao
 * @UpdateDate: 2021/4/13 9:41
 * @UpdateRemark: 无
 */
interface ApiService {

    @GET("search/repositories?sort=stars")
    suspend fun searchRepos(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") itemsPerPage: Int
    ): HomeData
}