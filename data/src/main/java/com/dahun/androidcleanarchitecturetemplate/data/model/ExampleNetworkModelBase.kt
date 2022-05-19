package com.dahun.androidcleanarchitecturetemplate.data.model

data class ExampleNetworkModelBase<T>(
    val data: T,
    val result: ExampleNetworkResult
)

data class ExampleNetworkResult(
    val message: String,
    val code: Int
)
