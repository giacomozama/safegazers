package test.safegazers.sdk.domain.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class JsonSimpleUser(
    override val login: String,
    override val id: Int,
    @Json(name = "node_id") override val nodeId: String,
    @Json(name = "avatar_url") override val avatarUrl: String,
    @Json(name = "gravatar_id") override val gravatarId: String,
    override val url: String,
    @Json(name = "html_url") override val htmlUrl: String,
    @Json(name = "followers_url") override val followersUrl: String,
    @Json(name = "following_url") override val followingUrl: String,
    @Json(name = "gists_url") override val gistsUrl: String,
    @Json(name = "starred_url") override val starredUrl: String,
    @Json(name = "subscriptions_url") override val subscriptionsUrl: String,
    @Json(name = "organizations_url") override val organizationsUrl: String,
    @Json(name = "repos_url") override val reposUrl: String,
    @Json(name = "events_url") override val eventsUrl: String,
    @Json(name = "received_events_url") override val receivedEventsUrl: String,
    override val type: String,
    @Json(name = "site_admin") override val siteAdmin: Boolean,
    override val name: String?,
    override val email: String?
) : SimpleUser