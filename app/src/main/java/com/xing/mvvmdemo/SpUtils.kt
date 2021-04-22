package com.xing.mvvmdemo

import android.content.Context

/**
 *
 * @ProjectName: mvvmdemo
 * @Description: 作用描述 <todo>
 * @Author: xinxing.tao
 * @CreateDate: 2021/4/13 10:17
 * @UpdateUser: xinxing.tao
 * @UpdateDate: 2021/4/13 10:17
 * @UpdateRemark: 无
 */

fun writeString(context: Context, key: String, value: String) {
    context.getSharedPreferences("cache", Context.MODE_PRIVATE).apply {
        val edit = edit()
        edit.putString(key, value)
        edit.apply()
    }
}


fun readString(context: Context, key: String, value: String): String {
    val sp = context.getSharedPreferences("cache", Context.MODE_PRIVATE)
    return sp.getString(key, value) ?: ""
}


