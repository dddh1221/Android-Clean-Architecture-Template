package com.dahun.androidcleanarchitecturetemplate.data.di

import com.dahun.androidcleanarchitecturetemplate.data.repository.ExampleUserRepositoryImpl
import com.dahun.androidcleanarchitecturetemplate.domain.repository.ExampleUserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindUserRepository(
        userRepositoryImpl: ExampleUserRepositoryImpl
    ): ExampleUserRepository

}