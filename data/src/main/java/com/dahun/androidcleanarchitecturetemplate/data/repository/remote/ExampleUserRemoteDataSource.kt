package com.dahun.androidcleanarchitecturetemplate.data.repository.remote

import com.dahun.androidcleanarchitecturetemplate.data.core.ApiResponse
import com.dahun.androidcleanarchitecturetemplate.data.model.api.ExampleResUser

interface ExampleUserRemoteDataSource {

    suspend fun getUser(): ApiResponse<ExampleResUser>

}