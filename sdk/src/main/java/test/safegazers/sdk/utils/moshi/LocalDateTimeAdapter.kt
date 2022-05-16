package test.safegazers.sdk.utils.moshi

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


internal class LocalDateTimeAdapter {

    @ToJson
    fun toJson(value: LocalDateTime): String = Formatter.format(value)

    @FromJson
    fun fromJson(value: String): LocalDateTime = LocalDateTime.parse(value, Formatter)


    companion object {
        private val Formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
    }
}
