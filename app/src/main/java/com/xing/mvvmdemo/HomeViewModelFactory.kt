package com.xing.mvvmdemo

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 *
 * @ProjectName: mvvmdemo
 * @Description: 作用描述 <todo>
 * @Author: xinxing.tao
 * @CreateDate: 2021/4/13 10:54
 * @UpdateUser: xinxing.tao
 * @UpdateDate: 2021/4/13 10:54
 * @UpdateRemark: 无
 */
class HomeViewModelFactory(private val application: Application, private val params: String) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == HomeViewModel::class.java) {
            return HomeViewModel(application, params) as T
        }
        return super.create(modelClass)
    }
}