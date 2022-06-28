package com.dahun.androidcleanarchitecturetemplate.presentation.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dahun.androidcleanarchitecturetemplate.presentation.R
import com.dahun.androidcleanarchitecturetemplate.presentation.core.BaseActivity
import com.dahun.androidcleanarchitecturetemplate.presentation.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}