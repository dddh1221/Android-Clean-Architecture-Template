package com.dahun.androidcleanarchitecturetemplate.data.core

import com.dahun.androidcleanarchitecturetemplate.data.model.ExampleNetworkModelBase
import com.google.gson.Gson
import retrofit2.Response

sealed class ApiResponse<T> {
    companion object {
        suspend fun <T> create(requestFunc: suspend () -> Response<ExampleNetworkModelBase<T>>): ApiResponse<T> {
            return try {
                val response = requestFunc.invoke()
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body == null || response.code() == 204) {
                        ApiEmptyResponse()
                    } else {
                        ApiSuccessResponse(body = body.data)
                    }
                } else {
                    val msg = response.errorBody()?.string()
                    val errorMsg = if(msg.isNullOrEmpty()) {
                        response.message()
                    } else {
                        Gson().fromJson(msg, ExampleNetworkModelBase::class.java).result.message
                    }

                    ApiErrorResponse(errorMessage = errorMsg ?: "Unknown Error", code = response.code())
                }
            } catch (e: Exception) {
                ApiErrorResponse(e.message ?: "Unknown Error", e)
            }
        }
    }
}

class ApiEmptyResponse<T> : ApiResponse<T>()
data class ApiSuccessResponse<T>(val body: T) : ApiResponse<T>()
data class ApiErrorResponse<T>(val errorMessage: String, val exception: Exception? = null, val code: Int? = null, val body: T? = null): ApiResponse<T>()