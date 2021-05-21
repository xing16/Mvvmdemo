package com.xing.mvvmdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 *
 * @ProjectName: mvvmdemo
 * @Description: 作用描述 <todo>
 * @Author: xinxing.tao
 * @CreateDate: 2021/4/22 16:30
 * @UpdateUser: xinxing.tao
 * @UpdateDate: 2021/4/22 16:30
 * @UpdateRemark: 无
 */
class BaseViewModel: ViewModel() {


    fun cc() {
        viewModelScope.launch {

        }
    }



    override fun onCleared() {
        super.onCleared()

    }




}