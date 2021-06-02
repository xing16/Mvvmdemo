package com.xing.mvvmdemo.sample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xing.mvvmdemo.http.Result
import com.xing.mvvmdemo.sample.ArticleData
import com.xing.mvvmdemo.sample.repository.IWanRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 *
 * @ProjectName: mvvmdemo
 * @Description: 作用描述 <todo>
 * @Author: xinxing.tao
 * @CreateDate: 2021/5/31 13:21
 * @UpdateUser: xinxing.tao
 * @UpdateDate: 2021/5/31 13:21
 * @UpdateRemark: 无
 */
class StateFlowViewModel(private val wanRepository: IWanRepository) : ViewModel() {

    private val _list: MutableStateFlow<Result<ArticleData>> = MutableStateFlow(Result.Error(Exception()))
    val list: StateFlow<Result<ArticleData>> = _list

    fun getList(page: Int) {
        viewModelScope.launch {
            wanRepository.getArticle(page).collect {
                _list.value = it
            }
        }
    }
}