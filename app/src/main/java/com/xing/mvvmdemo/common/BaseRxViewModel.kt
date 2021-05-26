package com.xing.mvvmdemo.common

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 *
 * @ProjectName: mvvmdemo
 * @Description: 作用描述 <todo>
 * @Author: xinxing.tao
 * @CreateDate: 2021/5/26 9:37
 * @UpdateUser: xinxing.tao
 * @UpdateDate: 2021/5/26 9:37
 * @UpdateRemark: 无
 */
class BaseRxViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    protected fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    private fun clear() {
        compositeDisposable.clear()
    }

    override fun onCleared() {
        super.onCleared()
        clear()
    }
}