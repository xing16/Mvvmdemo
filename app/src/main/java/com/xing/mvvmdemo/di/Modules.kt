package com.xing.mvvmdemo.di

import com.xing.mvvmdemo.wan.*
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
        WanViewModel2(get())
    }
}