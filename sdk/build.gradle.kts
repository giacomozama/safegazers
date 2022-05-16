plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

repositories {
    flatDir {
        dirs("libs")
    }
}

android {
    compileSdk = Versions.CompileSdk

    defaultConfig {
        minSdk = 23
        targetSdk = Versions.TargetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            packagingOptions {
                resources.excludes += "DebugProbesKt.bin"
            }
        }
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true

        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    coreLibraryDesugaring(Libs.desugaring)

    implementation(Libs.Kotlin.coroutines)
    implementation(Libs.AndroidX.Paging.common)
    implementation(Libs.Dagger.dagger)
    implementation(Libs.retrofit)
    implementation(Libs.rootBeer)
    implementation(Libs.Moshi.retrofit)
    implementation(Libs.Moshi.moshi)

    kapt(Libs.Moshi.codeGen)
    kapt(Libs.Dagger.compiler)

    testImplementation(Libs.jUnit)
    androidTestImplementation(Libs.AndroidX.androidJUnit)
    androidTestImplementation(Libs.AndroidX.espresso)
    androidTestImplementation(Libs.AndroidX.Compose.uiTestJUnit)
}