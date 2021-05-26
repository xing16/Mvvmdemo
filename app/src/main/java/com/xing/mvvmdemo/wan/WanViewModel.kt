package com.xing.mvvmdemo.wan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xing.mvvmdemo.http.data
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 *
 * @ProjectName: mvvmdemo
 * @Description: 作用描述 <todo>
 * @Author: xinxing.tao
 * @CreateDate: 2021/5/24 10:20
 * @UpdateUser: xinxing.tao
 * @UpdateDate: 2021/5/24 10:20
 * @UpdateRemark: 无
 */
class WanViewModel(private val wanUseCase: WanUseCase) : ViewModel() {

    private val _articleList = MutableLiveData<List<Article>>()

    val articleList: LiveData<List<Article>> = _articleList


    fun getArticle(page: Int) {
        viewModelScope.launch {
            wanUseCase(WanRequest(page)).collect {
                val result = it.data ?: return@collect
                _articleList.value = result.datas
            }
        }
    }
}