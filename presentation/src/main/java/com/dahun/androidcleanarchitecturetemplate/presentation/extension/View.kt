package com.dahun.androidcleanarchitecturetemplate.presentation.extension

import android.app.Activity
import android.view.View

fun View.makeVisible() {
    visibility = View.VISIBLE
}

fun View.makeInvisible() {
    visibility = View.INVISIBLE
}

fun View.makeGone() {
    visibility = View.GONE
}