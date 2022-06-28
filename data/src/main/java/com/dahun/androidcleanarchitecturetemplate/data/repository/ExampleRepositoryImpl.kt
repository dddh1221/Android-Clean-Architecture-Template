package com.dahun.androidcleanarchitecturetemplate.data.repository

import com.dahun.androidcleanarchitecturetemplate.domain.core.Result
import com.dahun.androidcleanarchitecturetemplate.domain.repository.ExampleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExampleRepositoryImpl @Inject constructor(
    /** Inject Your Data Source **/
): ExampleRepository {

    override fun example(): Flow<Result<Any>> {
        TODO("Not yet implemented")
    }

}