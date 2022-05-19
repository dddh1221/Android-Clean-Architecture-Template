package com.dahun.androidcleanarchitecturetemplate.data.model

abstract class ExampleDbModelBase(
    open val updateTime: Long? = System.currentTimeMillis()
)
