package test.safegazers.sdk.security

@JvmInline
value class SecurityCheckSpec(private val spec: Int) {

    val isSkipEmulationCheck get() = spec and Flags.SkipEmulationCheck != 0

    val isSkipRootCheck get() = spec and Flags.SkipRootCheck != 0

    val isSkipPackageNameCheck get() = spec and Flags.SkipPackageNameCheck != 0

    val isSkipAndroidVersionCheck get() = spec and Flags.SkipAndroidVersionCheck != 0

    val isSkipReceiversInManifestCheck get() = spec and Flags.SkipReceiversInManifestCheck != 0

    val isForgiveErrors get() = spec and Flags.ForgiveErrors != 0


    class Builder {

        private var spec: Int = 0


        fun skipEmulationCheck() {
            spec = spec or Flags.SkipEmulationCheck
        }

        fun skipRootCheck() {
            spec = spec or Flags.SkipRootCheck
        }

        fun skipPackageNameCheck() {
            spec = spec or Flags.SkipPackageNameCheck
        }

        fun skipAndroidVersionCheck() {
            spec = spec or Flags.SkipAndroidVersionCheck
        }

        fun skipReceiversInManifestCheck() {
            spec = spec or Flags.SkipReceiversInManifestCheck
        }

        fun forgiveErrors() {
            spec = spec or Flags.ForgiveErrors
        }

        fun build() = SecurityCheckSpec(spec)
    }


    private object Flags {

        const val SkipEmulationCheck = 1

        const val SkipRootCheck = 2

        const val SkipPackageNameCheck = 4

        const val SkipAndroidVersionCheck = 8

        const val SkipReceiversInManifestCheck = 16

        const val ForgiveErrors = 32
    }

    companion object {

        val Default = SecurityCheckSpec(0)
    }
}

