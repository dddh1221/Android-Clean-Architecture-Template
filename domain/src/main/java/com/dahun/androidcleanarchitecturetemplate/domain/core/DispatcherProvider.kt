package com.dahun.androidcleanarchitecturetemplate.domain.core

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {

    val default: CoroutineDispatcher

    val io: CoroutineDispatcher

    val main: CoroutineDispatcher

}