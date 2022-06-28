package com.dahun.androidcleanarchitecturetemplate.presentation.extension

fun Boolean.isTrue(action: () -> Unit) {
    if(this) action()
}