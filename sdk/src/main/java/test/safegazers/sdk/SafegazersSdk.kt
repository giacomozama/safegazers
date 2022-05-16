package test.safegazers.sdk

import test.safegazers.sdk.di.DaggerSdkComponent

object SafegazersSdk {

    private val component = DaggerSdkComponent.create()

    val DefaultSafeStargazersService = component.defaultSafeStargazersService()

    val DefaultSecurityStateProvider = component.defaultSecurityStateProvider()

    val SafeStargazersServiceFactory = component.safeStargazersServiceFactory()

    val SecurityStateProviderFactory = component.safeSecurityStateProviderFactory()
}