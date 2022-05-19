// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.library") version "7.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.6.21" apply false
    id("com.android.application") version "7.2.0" apply false
    kotlin("kapt") version "1.6.21" apply false
    id("com.google.dagger.hilt.android") version Versions.HILT apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}