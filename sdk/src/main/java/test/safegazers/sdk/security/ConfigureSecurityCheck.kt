package test.safegazers.sdk.security


inline fun configureSecurityCheck(create: SecurityCheckSpec.Builder.() -> Unit): SecurityCheckSpec {
    val builder = SecurityCheckSpec.Builder()
    builder.create()
    return builder.build()
}