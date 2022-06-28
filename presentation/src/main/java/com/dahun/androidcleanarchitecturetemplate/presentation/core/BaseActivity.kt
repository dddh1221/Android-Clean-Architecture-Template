package com.dahun.androidcleanarchitecturetemplate.presentation.core

import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.hilt.android.AndroidEntryPoint

abstract class BaseActivity<VB: ViewDataBinding>(
    private val inflater: (LayoutInflater) -> VB
): AppCompatActivity() {

    private lateinit var _binding: VB
    val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = inflater(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this
    }


}