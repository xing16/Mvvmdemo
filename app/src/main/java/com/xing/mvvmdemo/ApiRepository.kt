package com.xing.mvvmdemo

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *
 * @ProjectName: mvvmdemo
 * @Description: 作用描述 <todo>
 * @Author: xinxing.tao
 * @CreateDate: 2021/4/13 9:19
 * @UpdateUser: xinxing.tao
 * @UpdateDate: 2021/4/13 9:19
 * @UpdateRemark: 无
 */
object ApiRepository {

    suspend fun fetchData(query: String, page: Int, perPage: Int): RepoSearchResponse {
        return withContext(Dispatchers.IO) {
            RetrofitClient.create(ApiService::class.java).searchRepos(query, page, perPage)
        }
    }

    suspend fun writeCache(context: Context, content: String) {
        withContext(Dispatchers.IO) {
            writeString(context, "content", content)
        }
    }

    suspend fun readCache(context: Context): String {
        return withContext(Dispatchers.IO) {
            readString(context, "content", "")
        }
    }
}