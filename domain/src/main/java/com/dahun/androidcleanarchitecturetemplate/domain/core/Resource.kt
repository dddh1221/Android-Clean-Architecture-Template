package com.dahun.androidcleanarchitecturetemplate.domain.core

sealed class Resource<T>(
    val data: T? = null,
    val code: Int? = null,
    val message: String? = null
) {
    class Success<T>(data: T, code: Int? = null) : Resource<T>(data, code = code)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(code: Int? = null, message: String, data: T? = null) : Resource<T>(data = data, code = code, message = message)
}
