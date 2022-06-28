package com.dahun.androidcleanarchitecturetemplate.presentation.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dahun.androidcleanarchitecturetemplate.domain.core.Result

abstract class BaseViewModel: ViewModel() {

    private val _uiState: MutableLiveData<UiState> = MutableLiveData(UiState.newInstance())
    val uiState: LiveData<UiState> = _uiState

    open protected fun <T> onLoading(data: T?) {
    }

    open protected fun <T> onSuccess(data: T?, code: Int?) {
    }

    open protected fun <T> onError(code: Int?, message: String, any: T?) {
        setUiStateError(Error(code, message))
    }

    protected fun <T> Result<T>.stateHandler() = ResultHandler(this)

    private fun setUiStateError(error: Error) {
        _uiState.value = (uiState.value ?: UiState.newInstance()).copy(error = Event(error))
    }

    private fun setUiStateLoading(isLoading: Boolean) {
        _uiState.value = (uiState.value ?: UiState.newInstance()).copy(isLoading = Event(isLoading))
    }

    inner class ResultHandler<T, R: Result<T>> (private val result: R) {
        private var loadingActionAndFinishedHandle: ((data: T?) -> Boolean)? = null
        private var successActionAndFinishedHandle: ((data: T?, code: Int?) -> Boolean)? = null
        private var errorActionAndFinishedHandle: ((code: Int?, message: String, any: T?) -> Boolean)? = null

        fun isLoading(action: (data: T?) -> Boolean): ResultHandler<T, R> {
            loadingActionAndFinishedHandle = action
            return this
        }

        fun isSuccess(action: (data: T?, code: Int?) -> Boolean): ResultHandler<T, R> {
            successActionAndFinishedHandle = action
            return this
        }

        fun isError(action: (code: Int?, message: String, any: T?) -> Boolean): ResultHandler<T, R> {
            errorActionAndFinishedHandle = action
            return this
        }

        fun handle() {
            result.isLoading { data ->
                loadingActionAndFinishedHandle?.let { action ->
                    if(!action(data)) {
                        setUiStateLoading(true)
                        onLoading(data)
                    }
                } ?: run {
                    onLoading(data)
                }
            }

            result.isSuccess { data, code ->
                setUiStateLoading(false)
                successActionAndFinishedHandle?.let { action ->
                    if(!action(data, code)) {
                        onSuccess(data, code)
                    }
                } ?: run {
                    onSuccess(data, code)
                }
            }

            result.isError { code, message, data ->
                setUiStateLoading(false)
                errorActionAndFinishedHandle?.let { action ->
                    if(!action(code, message, data)) {
                        onError(code, message, data)
                    }
                } ?: run {
                    onError(code, message, data)
                }
            }
        }

    }
}