package com.dahun.androidcleanarchitecturetemplate.data.repository.local

import com.dahun.androidcleanarchitecturetemplate.data.model.db.ExampleUserEntity
import kotlinx.coroutines.flow.Flow

interface ExampleUserLocalDataSource {

    fun loadUser(): Flow<ExampleUserEntity>

    suspend fun saveUser(user: ExampleUserEntity)

}