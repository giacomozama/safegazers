
plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Versions.CompileSdk

    defaultConfig {
        applicationId = "test.safegazers"
        minSdk = 23
        targetSdk = Versions.TargetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner" // "test.safegazers.SafegazersTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true

        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"

        freeCompilerArgs = freeCompilerArgs + listOf(
            "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi"
        )
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":sdk"))

    coreLibraryDesugaring(Libs.desugaring)

    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.Compose.ui)
    implementation(Libs.AndroidX.Compose.material)
    implementation(Libs.AndroidX.Compose.uiToolingPreview)
    implementation(Libs.AndroidX.Lifecycle.runtime)
    implementation(Libs.AndroidX.Lifecycle.viewModelCompose)
    implementation(Libs.AndroidX.activityCompose)

    implementation(Libs.AndroidX.Paging.runtime)
    implementation(Libs.AndroidX.Paging.compose)

    implementation(Libs.Dagger.Hilt.android)
    kapt(Libs.Dagger.Hilt.compiler)
    kaptAndroidTest(Libs.Dagger.Hilt.compiler)
    androidTestImplementation(Libs.Dagger.Hilt.testing)

    testImplementation(Libs.jUnit)
    androidTestImplementation(Libs.AndroidX.androidJUnit)
    androidTestImplementation(Libs.AndroidX.espresso)
    androidTestImplementation(Libs.AndroidX.Compose.uiTestJUnit)

    debugImplementation(Libs.AndroidX.Compose.uiTooling)
    // debugImplementation "androidx.compose.ui:ui-test-manifest:${Versions.compose}"
}

kapt {
    correctErrorTypes = true
}