# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.kts.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile


-keep class test.safegazers.sdk.security.ConfigureSecurityCheckKt {
    *;
}

-keep class test.safegazers.sdk.SafegazersSdk
-keepclassmembers class test.safegazers.sdk.SafegazersSdk {
    *;
}

-keep interface test.safegazers.sdk.domain.entities.*
-keepclassmembers interface test.safegazers.sdk.domain.entities.* {
    public <methods>;
}

-keep interface test.safegazers.sdk.domain.service.SafeStargazersServiceFactory
-keepclassmembers interface test.safegazers.sdk.domain.service.SafeStargazersServiceFactory {
    public <methods>;
}

-keep interface test.safegazers.sdk.domain.service.SafeStargazersService
-keepclassmembers interface test.safegazers.sdk.domain.service.SafeStargazersService {
    public <methods>;
}

-keep interface test.safegazers.sdk.security.state.SecurityState
-keepclassmembers interface test.safegazers.sdk.security.state.SecurityState {
    public <methods>;
}

-keep interface test.safegazers.sdk.security.state.SecurityStateProvider
-keepclassmembers interface test.safegazers.sdk.security.state.SecurityStateProvider {
    public <methods>;
}

-keep interface test.safegazers.sdk.security.state.SecurityStateProviderFactory
-keepclassmembers interface test.safegazers.sdk.security.state.SecurityStateProviderFactory {
    public <methods>;
}

-keep class test.safegazers.sdk.security.SecurityCheckSpec
-keepclassmembers class test.safegazers.sdk.security.SecurityCheckSpec {
    public <methods>;
}

-keep class test.safegazers.sdk.security.SecurityCheckSpec$Builder
-keepclassmembers class test.safegazers.sdk.security.SecurityCheckSpec$Builder {
    public <methods>;
}
