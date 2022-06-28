package com.dahun.androidcleanarchitecturetemplate.presentation.extension

import androidx.fragment.app.Fragment
import com.dahun.androidcleanarchitecturetemplate.presentation.extension.hideKeyboard
import com.dahun.androidcleanarchitecturetemplate.presentation.extension.showKeyboard

fun Fragment.showKeyboard() = activity?.showKeyboard()
fun Fragment.hideKeyboard() = activity?.hideKeyboard()