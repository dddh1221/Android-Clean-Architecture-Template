package com.dahun.androidcleanarchitecturetemplate.data.core

import com.dahun.androidcleanarchitecturetemplate.data.model.api.ExampleResUser
import com.dahun.androidcleanarchitecturetemplate.data.model.db.ExampleUserEntity
import com.dahun.androidcleanarchitecturetemplate.domain.entity.ExampleUser

fun ExampleUserEntity.toDomainEntity(): ExampleUser {
    return ExampleUser(
        name = this.name,
        gender = this.gender,
        birthYear = this.birthYear,
        birthMonth = this.birthMonth,
        birthDayOfMonth = this.birthDayOfMonth
    )
}

fun ExampleResUser.toDbModel(): ExampleUserEntity {
    return ExampleUserEntity(
        id = this.id,
        name = this.name,
        gender = this.gender,
        birthYear = this.birthYear,
        birthMonth = this.birthMonth,
        birthDayOfMonth = this.birthDayOfMonth
    )
}