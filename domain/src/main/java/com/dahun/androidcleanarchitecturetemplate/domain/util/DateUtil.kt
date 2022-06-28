package com.dahun.androidcleanarchitecturetemplate.domain.util

import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.*

object DateUtil {
    val ZONE_ID_KOR = ZoneId.of("Asia/Seoul")
    val TIME_ZONE_KOR = TimeZone.getTimeZone("Asia/Seoul")
    
    /**
     * String으로 된 날짜 형식을 Format에 맞추어 변환 후 Long형으로 반환
     */
    @JvmStatic
    fun transStrToLong(time: String, format: String): Long {
        val dateFormat = SimpleDateFormat(format, Locale.KOREAN)
        dateFormat.timeZone = TIME_ZONE_KOR
        val date = dateFormat.parse(time)
        return date.time
    }

    /**
     * Long형을 날짜 형식 Format에 맞추어 String으로 변환
     */
    @JvmStatic
    fun transLongToStr(time: Long, format: String): String {
        val date = Date(time)
        val dateFormat = SimpleDateFormat(format, Locale.KOREAN)
        dateFormat.timeZone = TIME_ZONE_KOR
        return dateFormat.format(date)

    }

    @JvmStatic
    fun transStrToFormatStr(time: String, beforeFormat: String, afterFormat: String): String {
        val time = transStrToLong(time, beforeFormat)
        return transLongToStr(time, afterFormat)
    }

    fun getTimeStampKor(): Long {
        val zonedDateTime = ZonedDateTime.now(ZONE_ID_KOR)
        return zonedDateTime.toInstant().toEpochMilli()
    }

    @JvmStatic
    fun isSameDate(reference: Long, compare: Long): Boolean {
        val referenceLocalDate = Instant.ofEpochMilli(reference).atZone(ZONE_ID_KOR).toLocalDate()
        val compareLocalDate = Instant.ofEpochMilli(compare).atZone(ZONE_ID_KOR).toLocalDate()

        return referenceLocalDate.isEqual(compareLocalDate)
    }

    @JvmStatic
    fun isToday(compare: Long): Boolean {
        val compareLocalDate = Instant.ofEpochMilli(compare).atZone(ZONE_ID_KOR).toLocalDate()
        val todayLocalDate = LocalDate.now()

        return todayLocalDate.isEqual(compareLocalDate)
    }
}