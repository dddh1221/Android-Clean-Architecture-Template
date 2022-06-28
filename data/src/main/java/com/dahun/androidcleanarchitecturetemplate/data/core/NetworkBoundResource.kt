package com.dahun.androidcleanarchitecturetemplate.data.core

import com.dahun.androidcleanarchitecturetemplate.domain.core.DispatcherProvider
import com.dahun.androidcleanarchitecturetemplate.domain.core.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.lang.Exception

abstract class NetworkBoundResource<Db, Network>(
    private val dispatcherProvider: DispatcherProvider
) {

    private val result = MutableStateFlow<Result<Db>>(Result.Loading())
    fun asFlow(): Flow<Result<Db>> = result.asStateFlow()

    init {
        setValue(Result.Loading())

        CoroutineScope(dispatcherProvider.io).launch {
            try {
                val dbSource = loadFromDb()
                dbSource.catch {
                    setValue(Result.Error(message = "Error!"))
                }.collect { data ->
                    if(data == null || shouldFetch(data)) {
                        fetchFromNetwork(data)
                    } else {
                        setValue(Result.Success(data))
                    }
                }
            } catch (e: Exception) {
                setValue(Result.Error(message = e.message ?: ""))
            }
        }
    }

    private fun setValue(newValue: Result<Db>) {
        if(result.value != newValue) {
            result.value = newValue
        }
    }

    private suspend fun fetchFromNetwork(originData: Db?) {
        setValue(Result.Loading())

        when(val apiResponse = createCall()) {
            is ApiSuccessResponse<Network> -> {
                saveCallResult(apiResponse.body)
            }

            is ApiEmptyResponse<Network> -> {
                setValue(Result.Error(-1, "Empty Data"))
            }

            is ApiErrorResponse<Network> -> {
                setValue(Result.Error(apiResponse.code, apiResponse.errorMessage))
            }
        }
    }

    protected abstract suspend fun saveCallResult(item: Network)

    protected abstract suspend fun shouldFetch(data: Db): Boolean

    protected abstract fun loadFromDb(): Flow<Db>

    protected abstract suspend fun createCall(): ApiResponse<Network>

}