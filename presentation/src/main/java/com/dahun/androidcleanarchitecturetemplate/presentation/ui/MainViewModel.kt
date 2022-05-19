package com.dahun.androidcleanarchitecturetemplate.presentation.ui

import com.dahun.androidcleanarchitecturetemplate.domain.core.DispatcherProvider
import com.dahun.androidcleanarchitecturetemplate.domain.usecase.ExampleGetUserUseCase
import com.dahun.androidcleanarchitecturetemplate.presentation.core.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserUseCase: ExampleGetUserUseCase,
    private val dispatcherProvider: DispatcherProvider
): BaseViewModel() {



}