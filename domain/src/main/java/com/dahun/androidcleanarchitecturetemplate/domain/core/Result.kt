package com.dahun.androidcleanarchitecturetemplate.domain.core

sealed class Result<T>(
    val data: T? = null,
    val code: Int? = null,
    val message: String? = null
) {
    class Success<T>(data: T, code: Int? = null) : Result<T>(data, code = code)
    class Loading<T>(data: T? = null) : Result<T>(data)
    class Error<T>(code: Int? = null, message: String, data: T? = null) : Result<T>(data = data, code = code, message = message)

    fun isSuccess(action: (data: T?, code: Int?) -> Unit) {
        if(this is Success) {
            action(this.data, this.code)
        }
    }

    fun isLoading(action: (data: T?) -> Unit) {
        if(this is Loading) {
            action(this.data)
        }
    }

    fun isError(action: (code: Int?, message: String, data: T?) -> Unit) {
        if(this is Error) {
            action(this.code, this.message!!, this.data)
        }
    }
}
