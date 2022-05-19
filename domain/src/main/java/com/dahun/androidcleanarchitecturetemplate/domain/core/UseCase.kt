package com.dahun.androidcleanarchitecturetemplate.domain.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class UseCase<out ReturnType, in Params> where ReturnType : Any {

    abstract suspend fun run(params: Params): ReturnType

    operator fun invoke(
        params: Params,
        scope: CoroutineScope,
        dispatcherProvider: DispatcherProvider,
        onResult: suspend (ReturnType) -> Unit = {}
    ) {
        scope.launch(dispatcherProvider.main) {
            val deferred = async(dispatcherProvider.io) {
                run(params)
            }
            onResult(deferred.await())
        }
    }

    class None

}