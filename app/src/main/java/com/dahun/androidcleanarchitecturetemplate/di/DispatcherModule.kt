package com.dahun.androidcleanarchitecturetemplate.di

import com.dahun.androidcleanarchitecturetemplate.core.DefaultDispatcherProvider
import com.dahun.androidcleanarchitecturetemplate.domain.core.DispatcherProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DispatcherModule {

    @Binds
    abstract fun bindDispatcherProvider(
        defaultDispatcherProvider: DefaultDispatcherProvider
    ): DispatcherProvider

}