import extension.*

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = AppConfig.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = AppConfig.MIN_SDK_VERSION
        targetSdk = AppConfig.TARGET_SDK_VERSION

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        dataBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":domain"))

    implementationLibs(Dependencies.Android)
    implementationLibs(Dependencies.Coroutine)
    implementationLibs(Dependencies.Material)

    implementationLibs(Dependencies.JetPack.Hilt)
    implementationLibs(Dependencies.JetPack.LifeCycle)
    implementationLibs(Dependencies.JetPack.Fragment)
    implementationLibs(Dependencies.JetPack.ConstraintLayout)
    implementationLibs(Dependencies.JetPack.Navigation)

    implementationLibs(Dependencies.JUnit)
    implementationLibs(Dependencies.MockK)
    implementationLibs(Dependencies.Espresso)
}