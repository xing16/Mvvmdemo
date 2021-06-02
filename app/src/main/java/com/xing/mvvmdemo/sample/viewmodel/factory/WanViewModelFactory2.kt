package com.xing.mvvmdemo.sample.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.xing.mvvmdemo.sample.repository.IWanRepository
import com.xing.mvvmdemo.sample.viewmodel.LiveDataViewModel

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
class WanViewModelFactory2(
   private val iWanRepository: IWanRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == LiveDataViewModel::class.java) {
            return LiveDataViewModel(iWanRepository) as T
        }
        return super.create(modelClass)
    }
}