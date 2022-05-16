
object Libs {
    const val jUnit = "junit:junit:4.13.2"

    const val desugaring = "com.android.tools:desugar_jdk_libs:1.1.5"

    const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"

    const val rootBeer = "com.scottyab:rootbeer-lib:0.1.0"

    object AndroidX {

        const val coreKtx = "androidx.core:core-ktx:1.7.0"
        const val activityCompose = "androidx.activity:activity-compose:1.4.0"

        const val androidJUnit = "androidx.test.ext:junit:1.1.3"
        const val espresso = "androidx.test.espresso:espresso-core:3.4.0"

        object Compose {

            const val ui = "androidx.compose.ui:ui:${Versions.Compose}"
            const val material = "androidx.compose.material:material:${Versions.Compose}"
            const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.Compose}"
            const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.Compose}"
            const val uiTestJUnit = "androidx.compose.ui:ui-test-junit4:${Versions.Compose}"
        }

        object Lifecycle {
            private const val version = "2.4.1"

            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
            const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$version"
        }

        object Paging {
            private const val version = "3.1.1"

            const val runtime = "androidx.paging:paging-runtime:$version"
            const val common = "androidx.paging:paging-common:$version"
            const val compose = "androidx.paging:paging-compose:1.0.0-alpha14"
        }
    }

    object Dagger {
        private const val version = "2.42"

        const val dagger = "com.google.dagger:dagger:$version"
        const val compiler = "com.google.dagger:dagger-compiler:$version"

        object Hilt {

            const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
            const val android = "com.google.dagger:hilt-android:$version"
            const val compiler = "com.google.dagger:hilt-android-compiler:$version"
            const val testing = "com.google.dagger:hilt-android-testing:$version"
        }
    }

    object Kotlin {
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1"
    }

    object Moshi {
        const val moshi = "com.squareup.moshi:moshi:1.13.0"
        const val codeGen = "com.squareup.moshi:moshi-kotlin-codegen:1.13.0"
        const val retrofit = "com.squareup.retrofit2:converter-moshi:2.9.0"
    }
}