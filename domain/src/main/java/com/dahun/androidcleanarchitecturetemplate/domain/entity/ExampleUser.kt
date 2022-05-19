package com.dahun.androidcleanarchitecturetemplate.domain.entity

data class ExampleUser(
    val name: String,
    val gender: ExampleGender,
    val birthYear: Int,
    val birthMonth: Int,
    val birthDayOfMonth: Int
) {

    constructor(name: String, gender: String, birthYear: Int, birthMonth: Int, birthDayOfMonth: Int)
            : this(name, ExampleGender.valueOf(gender), birthYear, birthMonth, birthDayOfMonth)
}
