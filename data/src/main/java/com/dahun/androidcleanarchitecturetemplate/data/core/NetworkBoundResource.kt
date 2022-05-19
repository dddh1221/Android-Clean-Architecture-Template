package com.dahun.androidcleanarchitecturetemplate.data.core

import com.dahun.androidcleanarchitecturetemplate.domain.core.DispatcherProvider
import com.dahun.androidcleanarchitecturetemplate.domain.core.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.lang.Exception

abstract class NetworkBoundResource<Db, Network>(
    private val dispatcherProvider: DispatcherProvider
) {

    private val result = MutableStateFlow<Resource<Db>>(Resource.Loading())
    fun asFlow(): Flow<Resource<Db>> = result.asStateFlow()

    init {
        setValue(Resource.Loading())

        CoroutineScope(dispatcherProvider.io).launch {
            try {
                val dbSource = loadFromDb()
                dbSource.catch {
                    setValue(Resource.Error(message = "Error!"))
                }.collect { data ->
                    if(data == null || shouldFetch(data)) {
                        fetchFromNetwork(data)
                    } else {
                        setValue(Resource.Success(data))
                    }
                }
            } catch (e: Exception) {
                setValue(Resource.Error(message = e.message ?: ""))
            }
        }
    }

    private fun setValue(newValue: Resource<Db>) {
        if(result.value != newValue) {
            result.value = newValue
        }
    }

    private suspend fun fetchFromNetwork(originData: Db?) {
        setValue(Resource.Loading())

        when(val apiResponse = createCall()) {
            is ApiSuccessResponse<Network> -> {
                saveCallResult(apiResponse.body)
            }

            is ApiEmptyResponse<Network> -> {
                setValue(Resource.Error(-1, "Empty Data"))
            }

            is ApiErrorResponse<Network> -> {
                setValue(Resource.Error(apiResponse.code, apiResponse.errorMessage))
            }
        }
    }

    protected abstract suspend fun saveCallResult(item: Network)

    protected abstract suspend fun shouldFetch(data: Db): Boolean

    protected abstract fun loadFromDb(): Flow<Db>

    protected abstract suspend fun createCall(): ApiResponse<Network>

}