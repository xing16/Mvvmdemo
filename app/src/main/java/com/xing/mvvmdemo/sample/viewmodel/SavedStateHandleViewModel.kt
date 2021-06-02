package com.xing.mvvmdemo.sample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

/**
 *
 * @ProjectName: mvvmdemo
 * @Description: 作用描述 <todo>
 * @Author: xinxing.tao
 * @CreateDate: 2021/5/31 13:54
 * @UpdateUser: xinxing.tao
 * @UpdateDate: 2021/5/31 13:54
 * @UpdateRemark: 无
 */
class SavedStateHandleViewModel(state: SavedStateHandle) : ViewModel() {

    companion object {
        private val USER_ID = "user_id"
        private val USER_NAME = "user_name"
    }

    private val mSavedStateHandle: SavedStateHandle = state

    //  getLiveData 方法会取得一个与 key 相关联的 MutableLiveData
    private val _name: MutableLiveData<String> = mSavedStateHandle.getLiveData(USER_NAME)

    // 只对外暴露不可变的 LiveData
    val name: LiveData<String> = _name

    fun getUserId() = mSavedStateHandle.get<String>(USER_ID) ?: ""

    fun setUserId(newUserId: String) {
        mSavedStateHandle.set(USER_ID, newUserId)
    }
}