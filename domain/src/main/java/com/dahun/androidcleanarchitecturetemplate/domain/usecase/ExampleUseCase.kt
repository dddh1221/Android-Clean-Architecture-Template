package com.dahun.androidcleanarchitecturetemplate.domain.usecase

import com.dahun.androidcleanarchitecturetemplate.domain.core.Result
import com.dahun.androidcleanarchitecturetemplate.domain.core.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ExampleUseCase @Inject constructor(
    /** 이 곳에 Repository 주입 **/
): UseCase<Flow<Result<Any>>, UseCase.None>() {

    override suspend fun run(params: None): Flow<Result<Any>> {
        TODO("Not yet implemented")
    }

    data class Params(
        /** 이 곳에 UseCase Parameter 작성 **/
        val example: Any
    )
}