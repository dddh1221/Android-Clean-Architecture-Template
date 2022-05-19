package com.dahun.androidcleanarchitecturetemplate.data.repository

import com.dahun.androidcleanarchitecturetemplate.data.core.ApiResponse
import com.dahun.androidcleanarchitecturetemplate.data.core.NetworkBoundResource
import com.dahun.androidcleanarchitecturetemplate.data.core.toDbModel
import com.dahun.androidcleanarchitecturetemplate.data.core.toDomainEntity
import com.dahun.androidcleanarchitecturetemplate.data.extension.mapData
import com.dahun.androidcleanarchitecturetemplate.data.model.api.ExampleResUser
import com.dahun.androidcleanarchitecturetemplate.data.model.db.ExampleUserEntity
import com.dahun.androidcleanarchitecturetemplate.data.repository.local.ExampleUserLocalDataSource
import com.dahun.androidcleanarchitecturetemplate.data.repository.remote.ExampleUserRemoteDataSource
import com.dahun.androidcleanarchitecturetemplate.domain.core.DispatcherProvider
import com.dahun.androidcleanarchitecturetemplate.domain.core.Resource
import com.dahun.androidcleanarchitecturetemplate.domain.entity.ExampleUser
import com.dahun.androidcleanarchitecturetemplate.domain.repository.ExampleUserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExampleUserRepositoryImpl @Inject constructor(
    private val userLocalDataSource: ExampleUserLocalDataSource,
    private val userRemoteDataSource: ExampleUserRemoteDataSource,
    private val dispatcherProvider: DispatcherProvider
): ExampleUserRepository {

    private val _user by lazy {
        object : NetworkBoundResource<ExampleUserEntity, ExampleResUser>(dispatcherProvider) {
            override suspend fun saveCallResult(item: ExampleResUser) {
                userLocalDataSource.saveUser(item.toDbModel())
            }

            override suspend fun shouldFetch(data: ExampleUserEntity): Boolean {
                return System.currentTimeMillis() - (data.updateTime ?: 0) >= TimeUnit.MILLISECONDS.convert(1, TimeUnit.HOURS)
            }

            override fun loadFromDb(): Flow<ExampleUserEntity> {
                return userLocalDataSource.loadUser()
            }

            override suspend fun createCall(): ApiResponse<ExampleResUser> {
                return userRemoteDataSource.getUser()
            }

        }
    }

    override fun getUser(): Flow<Resource<ExampleUser>> = _user.asFlow()
        .map { resource ->
            resource.mapData { original ->
                original?.toDomainEntity()
            }
        }
}