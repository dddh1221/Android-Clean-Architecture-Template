package com.dahun.androidcleanarchitecturetemplate.presentation.core

import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseFragment: Fragment() {

    val baseActivity: BaseActivity? by lazy {
        if(requireActivity() is BaseActivity) {
            requireActivity() as BaseActivity
        } else
            null
    }

    protected fun getVersionName(): String = requireContext().packageManager.getPackageInfo(requireContext().packageName, 0).versionName
}