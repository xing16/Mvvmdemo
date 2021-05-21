package com.xing.mvvmdemo.testbase

import com.xing.mvvmdemo.RetrofitClient
import com.xing.mvvmdemo.base.BaseRepository
import com.xing.mvvmdemo.base.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *
 * @ProjectName: mvvmdemo
 * @Description: 作用描述 <todo>
 * @Author: xinxing.tao
 * @CreateDate: 2021/5/18 9:51
 * @UpdateUser: xinxing.tao
 * @UpdateDate: 2021/5/18 9:51
 * @UpdateRemark: 无
 */
class WanRepository : BaseRepository() {

    suspend fun getBanner(): Result<List<BannerEntity>> {
        return withContext(Dispatchers.IO) {
            execute {
                RetrofitClient.create(WanApi::class.java).getBanner()
            }
        }
    }
}