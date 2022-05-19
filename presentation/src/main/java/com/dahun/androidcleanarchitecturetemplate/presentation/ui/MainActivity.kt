package com.dahun.androidcleanarchitecturetemplate.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dahun.androidcleanarchitecturetemplate.presentation.R
import com.dahun.androidcleanarchitecturetemplate.presentation.core.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}