package com.xing.mvvmdemo

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.google.gson.Gson
import com.xing.mvvmdemo.home.HomeData
import kotlinx.coroutines.*

/**
 *
 * @ProjectName: mvvmdemo
 * @Description: 作用描述 <todo>
 * @Author: xinxing.tao
 * @CreateDate: 2021/4/13 9:18
 * @UpdateUser: xinxing.tao
 * @UpdateDate: 2021/4/13 9:18
 * @UpdateRemark: 无
 */
class ApiHomeViewModel(
    application: Application,// 额外参数
    private val params: String
) : AndroidViewModel(application) {

    private val TAG = "HomeViewModel"

    @SuppressLint("StaticFieldLeak")
    private val context = getApplication<Application>().applicationContext

    private val _homeData: MutableLiveData<HomeData> = MutableLiveData<HomeData>()
    private val _loading: MutableLiveData<Boolean> = MutableLiveData<Boolean>()

    val homeData: LiveData<HomeData> = _homeData

    val loading: LiveData<Boolean> = _loading

    init {
        Log.e("debug", "params = $params")
    }

    fun fetchData(query: String, page: Int, perPage: Int) {
        _loading.value = true
        viewModelScope.launch(Dispatchers.Main) {
            // read cache
            val cacheJson = ApiRepository.readCache(context)
            Log.d(TAG, "cacheJson: $cacheJson")
            if (cacheJson.isNotEmpty()) {
                _loading.value = false
                val cache = Gson().fromJson(cacheJson, HomeData::class.java)
                _homeData.value = cache
            }
            val response = ApiRepository.fetchData(query, page, perPage)
            Log.d(TAG, "response: $response")
            _homeData.value = response
            _loading.value = false
            // write cache
            val jsonstring = Gson().toJson(response)
            ApiRepository.writeCache(context, jsonstring)
        }
    }
}