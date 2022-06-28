package com.dahun.androidcleanarchitecturetemplate.presentation.ui

import android.os.Bundle
import com.dahun.androidcleanarchitecturetemplate.presentation.core.BaseActivity
import com.dahun.androidcleanarchitecturetemplate.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}