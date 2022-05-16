package test.safegazers.sdk.domain.entities

import java.time.LocalDateTime

interface Stargazer {
    val starredAt: LocalDateTime
    val user: SimpleUser
}