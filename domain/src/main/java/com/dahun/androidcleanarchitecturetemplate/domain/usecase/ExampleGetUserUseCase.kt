package com.dahun.androidcleanarchitecturetemplate.domain.usecase

import com.dahun.androidcleanarchitecturetemplate.domain.core.Resource
import com.dahun.androidcleanarchitecturetemplate.domain.core.UseCase
import com.dahun.androidcleanarchitecturetemplate.domain.entity.ExampleUser
import com.dahun.androidcleanarchitecturetemplate.domain.repository.ExampleUserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ExampleGetUserUseCase @Inject constructor(
    private val userRepository: ExampleUserRepository
): UseCase<Flow<Resource<ExampleUser>>, UseCase.None>() {

    override suspend fun run(params: None): Flow<Resource<ExampleUser>> = userRepository.getUser()

}