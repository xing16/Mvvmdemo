package com.xing.mvvmdemo.di

import com.xing.mvvmdemo.sample.datasource.WanCacheDataSource
import com.xing.mvvmdemo.sample.datasource.WanRemoteDataSource
import com.xing.mvvmdemo.sample.repository.IWanRepository
import com.xing.mvvmdemo.sample.repository.WanRepositoryImpl
import com.xing.mvvmdemo.sample.viewmodel.LiveDataViewModel
import com.xing.mvvmdemo.sample.viewmodel.StateFlowViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 *
 * @ProjectName: mvvmdemo
 * @Description: 作用描述 <todo>
 * @Author: xinxing.tao
 * @CreateDate: 2021/5/25 18:38
 * @UpdateUser: xinxing.tao
 * @UpdateDate: 2021/5/25 18:38
 * @UpdateRemark: 无
 */
val dataSourceModule = module {
    factory {
        WanRemoteDataSource()
    }
    factory {
        WanCacheDataSource()
    }
}

val repositoryModule = module {
    single<IWanRepository> {
        WanRepositoryImpl(get(), get())
    }
}

val viewModelModule = module {
    viewModel {
        LiveDataViewModel(get())

    }
    viewModel {
        StateFlowViewModel(get())
    }
}