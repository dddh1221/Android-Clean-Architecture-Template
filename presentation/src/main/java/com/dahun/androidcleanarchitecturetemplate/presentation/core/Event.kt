package com.dahun.androidcleanarchitecturetemplate.presentation.core

class Event<out T>(private val content: T) {
    var hasBeenHandled = false

    fun getContentIfNotHandled(): T? {
        return if(hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    fun peekContent(): T = content
}