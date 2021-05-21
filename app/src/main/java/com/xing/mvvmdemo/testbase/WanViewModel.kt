package com.xing.mvvmdemo.testbase

import android.app.Application
import androidx.lifecycle.*

/**
 *
 * @ProjectName: mvvmdemo
 * @Description: 作用描述 <todo>
 * @Author: xinxing.tao
 * @CreateDate: 2021/5/18 10:05
 * @UpdateUser: xinxing.tao
 * @UpdateDate: 2021/5/18 10:05
 * @UpdateRemark: 无
 */
class WanViewModel(
    val application: Application,
    private val wanRepository: WanRepository
) : ViewModel() {
    private val _banners = MutableLiveData<List<BannerEntity>>()

    val banners: LiveData<List<BannerEntity>> = _banners

    fun getBanner() {
//        viewModelScope.launch {
//            val result = wanRepository.getBanner()
//            if (result is Result.Success) {
//                _banners.value = Result.Success<>
//            } else {
//
//            }
//        }
    }
}


class WanViewModelFactory(
    private val application: Application,
    private val wanRepository: WanRepository,
    private val params: String
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == WanViewModel::class.java) {
            return WanViewModel(application, wanRepository) as T
        }
        return super.create(modelClass)
    }
}
