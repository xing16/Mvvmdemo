package com.xing.mvvmdemo.wan

import android.util.Log
import android.widget.Toast
import com.xing.mvvmdemo.http.ApiException
import com.xing.mvvmdemo.MainApplication
import com.xing.mvvmdemo.http.Response
import com.xing.mvvmdemo.common.base.BaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
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
//        return getArticleRemote(page)
        return getArticleRemote2(page)
    }

    private fun getArticleRemote(page: Int): Flow<Result<ArticleData>> {
        return flow {
            emit(Result.Loading)
            Log.e("debugdebug", "getArticle: " + Thread.currentThread().name)
            val response: Response<ArticleData> = remoteDataSource.getArticles(page)
            if (response.isSuccess) {
                emit(Result.Success(response.data))
            } else {
                emit(Result.Error(ApiException(response.errMsg ?: "", response.errorCode)))
            }
        }.catch { throwable: Throwable ->
            when (throwable) {
                is ConnectException,
                is SocketTimeoutException,
                is SocketException -> {
                    Toast.makeText(MainApplication.context, "网络连接异常", Toast.LENGTH_SHORT).show()
                }
                is HttpException -> {
                    val code = throwable.code()
                    println(code)
                }
                is UnknownHostException -> {

                }
            }
            emit(Result.Error(Exception(throwable)))
        }.flowOn(Dispatchers.IO)
    }


    private fun getArticleRemote2(page: Int): Flow<Result<ArticleData>> {
        return execute(page, remoteDataSource::getArticles)
    }

    private fun getArticleCache(): Flow<Result<ArticleData>> {
        return flow {

        }
    }
}