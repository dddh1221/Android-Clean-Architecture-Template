package com.dahun.androidcleanarchitecturetemplate.presentation.extension

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.os.Build

fun Context.getColorRes(colorId: Int, theme: Resources.Theme? = null): Int =
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        resources.getColor(colorId, theme)
    else
        resources.getColor(colorId)
