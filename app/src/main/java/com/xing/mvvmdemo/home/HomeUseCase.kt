package com.xing.mvvmdemo.home

import com.xing.mvvmdemo.base.AbsUserCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class HomeUseCase(
    private val homeRepository: HomeRepository,
    dispatcher: CoroutineDispatcher
) : AbsUserCase<HomeRequest, List<Repo>>(dispatcher) {

    override suspend fun execute(params: HomeRequest): List<Repo> {
        return homeRepository.searchHomeRepos(params.query, params.page, params.perPage).items.filter {
            it.language == "Kotlin"
        }
    }
}