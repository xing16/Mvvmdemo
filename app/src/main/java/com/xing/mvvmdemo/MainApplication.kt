package com.xing.mvvmdemo

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.xing.mvvmdemo.di.dataSourceModule
import com.xing.mvvmdemo.di.repositoryModule
import com.xing.mvvmdemo.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 *
 * @ProjectName: mvvmdemo
 * @Description: 作用描述 <todo>
 * @Author: xinxing.tao
 * @CreateDate: 2021/5/25 13:46
 * @UpdateUser: xinxing.tao
 * @UpdateDate: 2021/5/25 13:46
 * @UpdateRemark: 无
 */
class MainApplication : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(listOf(dataSourceModule, repositoryModule, viewModelModule))
        }
    }
}