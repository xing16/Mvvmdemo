package com.xing.mvvmdemo.koin

import com.xing.mvvmdemo.wan.IWanRepository
import com.xing.mvvmdemo.wan.WanDataSource
import com.xing.mvvmdemo.wan.WanRepository
import com.xing.mvvmdemo.wan.WanViewModel2
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
        WanDataSource()
    }
}

val repositoryModule = module {
    factory {
        WanRepository(get()) as IWanRepository
    }
}

val viewModelModule = module {
    viewModel {
        WanViewModel2(get())
    }
}