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
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        create("inhouse") {
            initWith(getByName("release"))
        }
    }
    flavorDimensions += "server"
    productFlavors {
        create("prod") {
            dimension = "server"
            buildConfigField("boolean", "IS_PROD", "true")
        }

        create("dev") {
            dimension = "server"
            buildConfigField("boolean", "IS_PROD", "false")
        }
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

    implementationLibs(Dependencies.Coroutine)
    implementationLibs(Dependencies.JetPack.Hilt)
    implementationLibs(Dependencies.JetPack.Room)
    implementationLibs(Dependencies.SQLite)
    implementationLibs(Dependencies.Retrofit)
}