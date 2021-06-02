package com.xing.mvvmdemo.sample.repository

import android.util.Log
import android.widget.Toast
import com.xing.mvvmdemo.MainApplication
import com.xing.mvvmdemo.common.base.BaseRepository
import com.xing.mvvmdemo.http.ApiException
import com.xing.mvvmdemo.http.Response
import com.xing.mvvmdemo.http.Result
import com.xing.mvvmdemo.sample.ArticleData
import com.xing.mvvmdemo.sample.datasource.WanCacheDataSource
import com.xing.mvvmdemo.sample.datasource.WanRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 *
 * @ProjectName: mvvmdemo
 * @Description: 作用描述 <todo>
 * @Author: xinxing.tao
 * @CreateDate: 2021/5/26 10:03
 * @UpdateUser: xinxing.tao
 * @UpdateDate: 2021/5/26 10:03
 * @UpdateRemark: 无
 */
class WanRepositoryImpl(
    private val remoteDataSource: WanRemoteDataSource,
    private val cacheDataSource: WanCacheDataSource? = null
) : BaseRepository(), IWanRepository {

    override suspend fun getArticle(page: Int): Flow<Result<ArticleData>> {
        return getArticleRemote2(page)
    }

    private fun getArticleRemote2(page: Int): Flow<Result<ArticleData>> {
        return execute(page, remoteDataSource::getArticles)
    }

    private fun getArticleCache(): Flow<Result<ArticleData>> {
        return flow {

        }
    }
}