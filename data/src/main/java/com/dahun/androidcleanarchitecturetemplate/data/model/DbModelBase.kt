package com.dahun.androidcleanarchitecturetemplate.data.model

abstract class DbModelBase(
    open val updateTime: Long? = System.currentTimeMillis()
)
