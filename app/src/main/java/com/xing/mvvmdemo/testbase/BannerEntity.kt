package com.xing.mvvmdemo.testbase

/**
 *
 * @ProjectName: mvvmdemo
 * @Description: 作用描述 <todo>
 * @Author: xinxing.tao
 * @CreateDate: 2021/5/18 9:55
 * @UpdateUser: xinxing.tao
 * @UpdateDate: 2021/5/18 9:55
 * @UpdateRemark: 无
 */
data class BannerEntity(
    val desc: String,
    val id: Int,
    val imagePath: String,
    val isVisible: Int,
    val order: Int,
    val title: String,
    val type: Int,
    val url: String
)