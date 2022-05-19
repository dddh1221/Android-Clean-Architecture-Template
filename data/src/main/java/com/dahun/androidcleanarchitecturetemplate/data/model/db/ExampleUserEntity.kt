package com.dahun.androidcleanarchitecturetemplate.data.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dahun.androidcleanarchitecturetemplate.data.model.ExampleDbModelBase

@Entity(tableName = "User")
data class ExampleUserEntity(
    @PrimaryKey
    var id: Int = 0,
    var name: String,
    var gender: String,
    var birthYear: Int,
    var birthMonth: Int,
    var birthDayOfMonth: Int
): ExampleDbModelBase()
