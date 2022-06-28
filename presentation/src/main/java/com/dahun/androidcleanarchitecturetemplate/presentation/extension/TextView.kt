package com.dahun.androidcleanarchitecturetemplate.presentation.extension

import android.widget.TextView

fun TextView.setTextColorRes(id: Int) {
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
        setTextColor(resources.getColor(id, null))
    }
    else {
        setTextColor(resources.getColor(id))
    }
}