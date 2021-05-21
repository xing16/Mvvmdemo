package com.xing.mvvmdemo

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *
 * @ProjectName: mvvmdemo
 * @Description: 作用描述 <todo>
 * @Author: xinxing.tao
 * @CreateDate: 2021/4/13 9:42
 * @UpdateUser: xinxing.tao
 * @UpdateDate: 2021/4/13 9:42
 * @UpdateRemark: 无
 */
object RetrofitClient {

    private var okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .build()
    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }
}