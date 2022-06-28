package com.dahun.androidcleanarchitecturetemplate.data.extension

import com.dahun.androidcleanarchitecturetemplate.domain.core.Result

internal fun <T, R> Result<T>.mapData(mapper: (T?) -> R?): Result<R> = when(this) {
    is Result.Success -> {
        this.data?.let { data -> Result.Success(mapper(data)!!, this.code) } ?: Result.Error(this.code, this.message ?: "")
    }

    is Result.Loading -> {
        Result.Loading(mapper(this.data))
    }

    is Result.Error -> {
        Result.Error(this.code, this.message ?: "", mapper(this.data))
    }
}