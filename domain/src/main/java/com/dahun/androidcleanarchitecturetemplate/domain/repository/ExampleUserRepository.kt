package com.dahun.androidcleanarchitecturetemplate.domain.repository

import com.dahun.androidcleanarchitecturetemplate.domain.core.Resource
import com.dahun.androidcleanarchitecturetemplate.domain.entity.ExampleUser
import kotlinx.coroutines.flow.Flow

interface ExampleUserRepository {

    fun getUser(): Flow<Resource<ExampleUser>>

}