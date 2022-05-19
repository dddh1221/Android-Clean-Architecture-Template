package com.dahun.androidcleanarchitecturetemplate.data.extension

import com.dahun.androidcleanarchitecturetemplate.domain.core.Resource

internal fun <T, R> Resource<T>.mapData(mapper: (T?) -> R?): Resource<R> = when(this) {
    is Resource.Success -> {
        this.data?.let { data -> Resource.Success(mapper(data)!!, this.code) } ?: Resource.Error(this.code, this.message ?: "")
    }

    is Resource.Loading -> {
        Resource.Loading(mapper(this.data))
    }

    is Resource.Error -> {
        Resource.Error(this.code, this.message ?: "", mapper(this.data))
    }
}