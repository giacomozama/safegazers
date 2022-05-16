package test.safegazers.sdk

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import test.safegazers.sdk.domain.entities.JsonStargazer
import test.safegazers.sdk.utils.moshi.LocalDateTimeAdapter


class ParsingTest {

    @Test
    fun parse_sample_json_response() {
        // region sample json
        val raw = """
        [
          {
            "starred_at": "2019-09-27T13:56:02Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******",
              "html_url": "https://github.com/aperfilyev",
              "followers_url": "https://api.github.com/users/*******/followers",
              "following_url": "https://api.github.com/users/*******/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******/subscriptions",
              "organizations_url": "https://api.github.com/users/*******/orgs",
              "repos_url": "https://api.github.com/users/*******/repos",
              "events_url": "https://api.github.com/users/*******/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-09-27T14:06:32Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******",
              "html_url": "https://github.com/Veeshal",
              "followers_url": "https://api.github.com/users/*******/followers",
              "following_url": "https://api.github.com/users/*******/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******/subscriptions",
              "organizations_url": "https://api.github.com/users/*******/orgs",
              "repos_url": "https://api.github.com/users/*******/repos",
              "events_url": "https://api.github.com/users/*******/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-09-27T19:52:06Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******",
              "html_url": "https://github.com/AkshayChordiya",
              "followers_url": "https://api.github.com/users/*******/followers",
              "following_url": "https://api.github.com/users/*******/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******/subscriptions",
              "organizations_url": "https://api.github.com/users/*******/orgs",
              "repos_url": "https://api.github.com/users/*******/repos",
              "events_url": "https://api.github.com/users/*******/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-09-27T19:59:06Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******",
              "html_url": "https://github.com/anunaym14",
              "followers_url": "https://api.github.com/users/*******/followers",
              "following_url": "https://api.github.com/users/*******/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******/subscriptions",
              "organizations_url": "https://api.github.com/users/*******/orgs",
              "repos_url": "https://api.github.com/users/*******/repos",
              "events_url": "https://api.github.com/users/*******/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-09-28T07:31:25Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******",
              "html_url": "https://github.com/TonnyL",
              "followers_url": "https://api.github.com/users/*******/followers",
              "following_url": "https://api.github.com/users/*******/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******/subscriptions",
              "organizations_url": "https://api.github.com/users/*******/orgs",
              "repos_url": "https://api.github.com/users/*******/repos",
              "events_url": "https://api.github.com/users/*******/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-09-29T01:56:17Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******",
              "html_url": "https://github.com/PatilShreyas",
              "followers_url": "https://api.github.com/users/*******/followers",
              "following_url": "https://api.github.com/users/*******/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******/subscriptions",
              "organizations_url": "https://api.github.com/users/*******/orgs",
              "repos_url": "https://api.github.com/users/*******/repos",
              "events_url": "https://api.github.com/users/*******/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-10-08T05:12:58Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******-it-weirdo",
              "html_url": "https://github.com/the-it-weirdo",
              "followers_url": "https://api.github.com/users/*******-it-weirdo/followers",
              "following_url": "https://api.github.com/users/*******-it-weirdo/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******-it-weirdo/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******-it-weirdo/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******-it-weirdo/subscriptions",
              "organizations_url": "https://api.github.com/users/*******-it-weirdo/orgs",
              "repos_url": "https://api.github.com/users/*******-it-weirdo/repos",
              "events_url": "https://api.github.com/users/*******-it-weirdo/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******-it-weirdo/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-10-09T08:16:04Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******",
              "html_url": "https://github.com/lzhang1007",
              "followers_url": "https://api.github.com/users/*******/followers",
              "following_url": "https://api.github.com/users/*******/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******/subscriptions",
              "organizations_url": "https://api.github.com/users/*******/orgs",
              "repos_url": "https://api.github.com/users/*******/repos",
              "events_url": "https://api.github.com/users/*******/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-10-15T01:58:27Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******",
              "html_url": "https://github.com/dector",
              "followers_url": "https://api.github.com/users/*******/followers",
              "following_url": "https://api.github.com/users/*******/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******/subscriptions",
              "organizations_url": "https://api.github.com/users/*******/orgs",
              "repos_url": "https://api.github.com/users/*******/repos",
              "events_url": "https://api.github.com/users/*******/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-10-15T08:52:07Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******",
              "html_url": "https://github.com/avdim",
              "followers_url": "https://api.github.com/users/*******/followers",
              "following_url": "https://api.github.com/users/*******/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******/subscriptions",
              "organizations_url": "https://api.github.com/users/*******/orgs",
              "repos_url": "https://api.github.com/users/*******/repos",
              "events_url": "https://api.github.com/users/*******/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-10-23T16:46:38Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******",
              "html_url": "https://github.com/andkulikov",
              "followers_url": "https://api.github.com/users/*******/followers",
              "following_url": "https://api.github.com/users/*******/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******/subscriptions",
              "organizations_url": "https://api.github.com/users/*******/orgs",
              "repos_url": "https://api.github.com/users/*******/repos",
              "events_url": "https://api.github.com/users/*******/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-10-23T18:39:15Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******",
              "html_url": "https://github.com/etonotieno",
              "followers_url": "https://api.github.com/users/*******/followers",
              "following_url": "https://api.github.com/users/*******/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******/subscriptions",
              "organizations_url": "https://api.github.com/users/*******/orgs",
              "repos_url": "https://api.github.com/users/*******/repos",
              "events_url": "https://api.github.com/users/*******/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-10-23T18:42:06Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******",
              "html_url": "https://github.com/arturonaredo",
              "followers_url": "https://api.github.com/users/*******/followers",
              "following_url": "https://api.github.com/users/*******/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******/subscriptions",
              "organizations_url": "https://api.github.com/users/*******/orgs",
              "repos_url": "https://api.github.com/users/*******/repos",
              "events_url": "https://api.github.com/users/*******/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-10-23T18:42:17Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******-ben",
              "html_url": "https://github.com/sergey-ben",
              "followers_url": "https://api.github.com/users/*******-ben/followers",
              "following_url": "https://api.github.com/users/*******-ben/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******-ben/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******-ben/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******-ben/subscriptions",
              "organizations_url": "https://api.github.com/users/*******-ben/orgs",
              "repos_url": "https://api.github.com/users/*******-ben/repos",
              "events_url": "https://api.github.com/users/*******-ben/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******-ben/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-10-23T18:53:17Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******",
              "html_url": "https://github.com/lukaville",
              "followers_url": "https://api.github.com/users/*******/followers",
              "following_url": "https://api.github.com/users/*******/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******/subscriptions",
              "organizations_url": "https://api.github.com/users/*******/orgs",
              "repos_url": "https://api.github.com/users/*******/repos",
              "events_url": "https://api.github.com/users/*******/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-10-23T18:53:54Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******",
              "html_url": "https://github.com/Foso",
              "followers_url": "https://api.github.com/users/*******/followers",
              "following_url": "https://api.github.com/users/*******/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******/subscriptions",
              "organizations_url": "https://api.github.com/users/*******/orgs",
              "repos_url": "https://api.github.com/users/*******/repos",
              "events_url": "https://api.github.com/users/*******/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-10-23T18:56:23Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******",
              "html_url": "https://github.com/oneSIX",
              "followers_url": "https://api.github.com/users/*******/followers",
              "following_url": "https://api.github.com/users/*******/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******/subscriptions",
              "organizations_url": "https://api.github.com/users/*******/orgs",
              "repos_url": "https://api.github.com/users/*******/repos",
              "events_url": "https://api.github.com/users/*******/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-10-23T19:13:00Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******",
              "html_url": "https://github.com/DroidPulkit",
              "followers_url": "https://api.github.com/users/*******/followers",
              "following_url": "https://api.github.com/users/*******/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******/subscriptions",
              "organizations_url": "https://api.github.com/users/*******/orgs",
              "repos_url": "https://api.github.com/users/*******/repos",
              "events_url": "https://api.github.com/users/*******/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-10-23T19:33:22Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******",
              "html_url": "https://github.com/oudommeas",
              "followers_url": "https://api.github.com/users/*******/followers",
              "following_url": "https://api.github.com/users/*******/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******/subscriptions",
              "organizations_url": "https://api.github.com/users/*******/orgs",
              "repos_url": "https://api.github.com/users/*******/repos",
              "events_url": "https://api.github.com/users/*******/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-10-23T19:57:54Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******",
              "html_url": "https://github.com/odaridavid",
              "followers_url": "https://api.github.com/users/*******/followers",
              "following_url": "https://api.github.com/users/*******/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******/subscriptions",
              "organizations_url": "https://api.github.com/users/*******/orgs",
              "repos_url": "https://api.github.com/users/*******/repos",
              "events_url": "https://api.github.com/users/*******/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-10-23T20:02:05Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******",
              "html_url": "https://github.com/wangerekaharun",
              "followers_url": "https://api.github.com/users/*******/followers",
              "following_url": "https://api.github.com/users/*******/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******/subscriptions",
              "organizations_url": "https://api.github.com/users/*******/orgs",
              "repos_url": "https://api.github.com/users/*******/repos",
              "events_url": "https://api.github.com/users/*******/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-10-23T20:16:50Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******-alejandro-reyes-milian",
              "html_url": "https://github.com/david-alejandro-reyes-milian",
              "followers_url": "https://api.github.com/users/*******-alejandro-reyes-milian/followers",
              "following_url": "https://api.github.com/users/*******-alejandro-reyes-milian/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******-alejandro-reyes-milian/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******-alejandro-reyes-milian/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******-alejandro-reyes-milian/subscriptions",
              "organizations_url": "https://api.github.com/users/*******-alejandro-reyes-milian/orgs",
              "repos_url": "https://api.github.com/users/*******-alejandro-reyes-milian/repos",
              "events_url": "https://api.github.com/users/*******-alejandro-reyes-milian/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******-alejandro-reyes-milian/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-10-23T20:18:27Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******",
              "html_url": "https://github.com/lauro299",
              "followers_url": "https://api.github.com/users/*******/followers",
              "following_url": "https://api.github.com/users/*******/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******/subscriptions",
              "organizations_url": "https://api.github.com/users/*******/orgs",
              "repos_url": "https://api.github.com/users/*******/repos",
              "events_url": "https://api.github.com/users/*******/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-10-23T20:37:50Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******",
              "html_url": "https://github.com/iyashamihsan",
              "followers_url": "https://api.github.com/users/*******/followers",
              "following_url": "https://api.github.com/users/*******/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******/subscriptions",
              "organizations_url": "https://api.github.com/users/*******/orgs",
              "repos_url": "https://api.github.com/users/*******/repos",
              "events_url": "https://api.github.com/users/*******/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-10-23T20:40:52Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******",
              "html_url": "https://github.com/davidfgc",
              "followers_url": "https://api.github.com/users/*******/followers",
              "following_url": "https://api.github.com/users/*******/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******/subscriptions",
              "organizations_url": "https://api.github.com/users/*******/orgs",
              "repos_url": "https://api.github.com/users/*******/repos",
              "events_url": "https://api.github.com/users/*******/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-10-23T22:41:03Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******",
              "html_url": "https://github.com/MoonWolf125",
              "followers_url": "https://api.github.com/users/*******/followers",
              "following_url": "https://api.github.com/users/*******/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******/subscriptions",
              "organizations_url": "https://api.github.com/users/*******/orgs",
              "repos_url": "https://api.github.com/users/*******/repos",
              "events_url": "https://api.github.com/users/*******/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-10-23T23:23:52Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******",
              "html_url": "https://github.com/JoaoPint0",
              "followers_url": "https://api.github.com/users/*******/followers",
              "following_url": "https://api.github.com/users/*******/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******/subscriptions",
              "organizations_url": "https://api.github.com/users/*******/orgs",
              "repos_url": "https://api.github.com/users/*******/repos",
              "events_url": "https://api.github.com/users/*******/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-10-23T23:53:54Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******",
              "html_url": "https://github.com/shoheikawano",
              "followers_url": "https://api.github.com/users/*******/followers",
              "following_url": "https://api.github.com/users/*******/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******/subscriptions",
              "organizations_url": "https://api.github.com/users/*******/orgs",
              "repos_url": "https://api.github.com/users/*******/repos",
              "events_url": "https://api.github.com/users/*******/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-10-24T00:24:57Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******",
              "html_url": "https://github.com/khairilushan",
              "followers_url": "https://api.github.com/users/*******/followers",
              "following_url": "https://api.github.com/users/*******/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******/subscriptions",
              "organizations_url": "https://api.github.com/users/*******/orgs",
              "repos_url": "https://api.github.com/users/*******/repos",
              "events_url": "https://api.github.com/users/*******/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******/received_events",
              "type": "User",
              "site_admin": false
            }
          },
          {
            "starred_at": "2019-10-24T00:32:05Z",
            "user": {
              "login": "******",
              "id": 64536565,
              "node_id": "*******",
              "avatar_url": "https://avatars.githubusercontent.com/u/*****?v=4",
              "gravatar_id": "",
              "url": "https://api.github.com/users/*******",
              "html_url": "https://github.com/takahirom",
              "followers_url": "https://api.github.com/users/*******/followers",
              "following_url": "https://api.github.com/users/*******/following{/other_user}",
              "gists_url": "https://api.github.com/users/*******/gists{/gist_id}",
              "starred_url": "https://api.github.com/users/*******/starred{/owner}{/repo}",
              "subscriptions_url": "https://api.github.com/users/*******/subscriptions",
              "organizations_url": "https://api.github.com/users/*******/orgs",
              "repos_url": "https://api.github.com/users/*******/repos",
              "events_url": "https://api.github.com/users/*******/events{/privacy}",
              "received_events_url": "https://api.github.com/users/*******/received_events",
              "type": "User",
              "site_admin": false
            }
          }
        ]
        """.trimIndent()
        // endregion
        val moshi = Moshi.Builder().add(LocalDateTimeAdapter()).build()
        val jsonAdapter = moshi.adapter<List<JsonStargazer>>()
        val parsed = jsonAdapter.fromJson(raw)
        assertNotNull(parsed)
        assertEquals(parsed!!.size, 30)
    }
}