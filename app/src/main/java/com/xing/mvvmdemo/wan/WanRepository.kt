package com.xing.mvvmdemo.wan

import android.util.Log
import android.widget.Toast
import com.xing.mvvmdemo.ApiException
import com.xing.mvvmdemo.MainApplication
import com.xing.mvvmdemo.base.Response
import com.xing.mvvmdemo.base.Result
import kotlinx.coroutines.CoroutineDispatcher
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
 * @CreateDate: 2021/5/24 10:15
 * @UpdateUser: xinxing.tao
 * @UpdateDate: 2021/5/24 10:15
 * @UpdateRemark: 无
 */


interface IWanRepository {

    suspend fun getArticle(page: Int): Flow<Result<ArticleData>>
}


open class BaseRepository(private val dispatcher: CoroutineDispatcher) {

    open fun <P, R> execute(p: P, block: (params: P) -> Response<R>): Flow<Result<R>> {
        return flow {
            // loading
            emit(Result.Loading)
            val response = block(p)
            if (response.isSuccess) {
                emit(Result.Success(response.data))
            } else {
                emit(Result.Error(ApiException(response.errMsg ?: "", response.errorCode)))
            }
        }.catch { exception ->
            emit(Result.Error(Exception(exception)))
        }.flowOn(dispatcher)
    }
}

class WanRepository(private val dataSource: WanDataSource) : IWanRepository {

    override suspend fun getArticle(page: Int): Flow<Result<ArticleData>> {
        return flow {
            emit(Result.Loading)
            Log.e("debugdebug", "getArticle: " + Thread.currentThread().name)
            val response: Response<ArticleData> = dataSource.getArticles(page)
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


}

//class WanRepository2(private val dataSource: WanDataSource, dispatcher: CoroutineDispatcher) : BaseRepository(dispatcher), IWanRepository {
//    override suspend fun getArticle(page: Int): Flow<Result<ArticleData>> {
//        return execute(page) {
//            dataSource::getArticles
//        }
//    }
//}