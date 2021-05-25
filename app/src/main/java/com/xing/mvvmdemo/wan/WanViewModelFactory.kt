package com.xing.mvvmdemo.wan

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.xing.mvvmdemo.home.HomeUseCase
import com.xing.mvvmdemo.home.HomeViewModel

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
class WanViewModelFactory(
   private val wanUseCase: WanUseCase,
    private val params: String? = null
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == WanViewModel::class.java) {
            return WanViewModel(wanUseCase) as T
        }
        return super.create(modelClass)
    }
}