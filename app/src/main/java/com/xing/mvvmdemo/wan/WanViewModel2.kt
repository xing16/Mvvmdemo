package com.xing.mvvmdemo.wan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 *
 * @ProjectName: mvvmdemo
 * @Description: 作用描述 <todo>
 * @Author: xinxing.tao
 * @CreateDate: 2021/5/25 10:08
 * @UpdateUser: xinxing.tao
 * @UpdateDate: 2021/5/25 10:08
 * @UpdateRemark: 无
 */
class WanViewModel2(private val wanRepository: IWanRepository) : ViewModel() {

    private val _articles = MutableLiveData<Result<ArticleData>>()
    val articles: LiveData<Result<ArticleData>> = _articles

    fun getArticleList(page: Int) {
        viewModelScope.launch() {
            wanRepository.getArticle(page).collect {
                _articles.value = it
            }
        }
    }
}