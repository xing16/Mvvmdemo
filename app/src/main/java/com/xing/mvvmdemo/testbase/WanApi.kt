package com.xing.mvvmdemo.testbase

import com.xing.mvvmdemo.base.Response

/**
 *
 * @ProjectName: mvvmdemo
 * @Description: 作用描述 <todo>
 * @Author: xinxing.tao
 * @CreateDate: 2021/5/18 9:53
 * @UpdateUser: xinxing.tao
 * @UpdateDate: 2021/5/18 9:53
 * @UpdateRemark: 无
 */
interface WanApi {

    suspend fun getBanner(): Response<List<BannerEntity>>
}