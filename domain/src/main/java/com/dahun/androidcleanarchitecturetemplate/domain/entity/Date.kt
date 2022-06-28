package com.dahun.androidcleanarchitecturetemplate.domain.entity

import com.dahun.androidcleanarchitecturetemplate.domain.util.DateUtil
import java.time.LocalDate
import java.time.LocalDateTime

data class Date(
    val year: Int,
    val month: Int,
    val dayOfMonth: Int,
    val hour: Int? = null,
    val minute: Int? = null,
    val sec: Int? = null
) {
    fun getEpochMillis(): Long = DateUtil.transStrToLong(
        time = String.format("%04d-%02d-%02d %02d:%02d:%02d", year, month, dayOfMonth, hour ?: 0, minute ?: 0, sec ?: 0),
        format = "yyyy-MM-dd HH:mm:ss"
    )

    companion object {
        fun now(): Date {
            val today = LocalDateTime.now()
            return Date(today.year, today.monthValue, today.dayOfMonth, today.hour, today.minute, today.second)
        }
    }
}
