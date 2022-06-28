package com.dahun.androidcleanarchitecturetemplate.domain.repository

import com.dahun.androidcleanarchitecturetemplate.domain.core.Result
import kotlinx.coroutines.flow.Flow

interface ExampleRepository {

    /**
     *  Repository Interface
     */

    fun example(): Flow<Result<Any>>
}