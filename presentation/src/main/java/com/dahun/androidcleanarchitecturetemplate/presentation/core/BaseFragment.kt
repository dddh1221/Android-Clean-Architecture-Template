package com.dahun.androidcleanarchitecturetemplate.presentation.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

typealias FragmentInflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB: ViewDataBinding>(
    private val inflate: FragmentInflate<VB>
): Fragment() {

    private lateinit var _binding: VB
    val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    protected fun getVersionName(): String = requireContext().packageManager.getPackageInfo(requireContext().packageName, 0).versionName
}