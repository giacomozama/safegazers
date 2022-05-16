package test.safegazers.sdk.domain.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.time.LocalDateTime

@JsonClass(generateAdapter = true)
internal data class JsonStargazer(
    @Json(name = "starred_at") override val starredAt: LocalDateTime,
    override val user: JsonSimpleUser
) : Stargazer