import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

plugins {
    id("com.github.ben-manes.versions") version "0.42.0"
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.Agp}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Kotlin}")
        classpath(Libs.Dagger.Hilt.gradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.named<DependencyUpdatesTask>("dependencyUpdates").configure {
    val regex = """^[0-9,.v-]+(-r)?$""".toRegex()
    val stableKeywords = setOf("RELEASE", "FINAL", "GA")

    fun isNonStable(version: String) = stableKeywords
        .none(version.toUpperCase()::contains)
        && !regex.matches(version)

    rejectVersionIf {
        isNonStable(candidate.version) && !isNonStable(currentVersion)
    }
}