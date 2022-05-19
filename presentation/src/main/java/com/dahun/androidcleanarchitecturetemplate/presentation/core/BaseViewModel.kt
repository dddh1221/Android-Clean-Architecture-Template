package com.dahun.androidcleanarchitecturetemplate.presentation.core

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dahun.androidcleanarchitecturetemplate.presentation.model.UiState

open class BaseViewModel: ViewModel() {

    private val _uiState: MutableLiveData<UiState> = MutableLiveData()

}