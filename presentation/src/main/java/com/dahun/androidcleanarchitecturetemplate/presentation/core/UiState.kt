package com.dahun.androidcleanarchitecturetemplate.presentation.core

data class UiState(
    val isLoading: Event<Boolean>,
    val error: Event<Error>
) {
    companion object {
        fun newInstance(): UiState {
            return UiState(
                isLoading = Event(false),
                error = Event(Error(0, ""))
            )
        }
    }
}
