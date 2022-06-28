import extension.*
import java.util.Properties
import java.io.FileInputStream

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

val keystorePropertiesFile = rootProject.file("keystore.properties")
val keystoreProperties = Properties()

keystoreProperties.load(FileInputStream(keystorePropertiesFile))

android {
    compileSdk = AppConfig.COMPILE_SDK_VERSION

    signingConfigs {
        create("release") {
            storeFile = file(keystoreProperties.getProperty("storeFile"))
            storePassword = keystoreProperties.getProperty("storePassword")
            keyAlias = keystoreProperties.getProperty("keyAlias")
            keyPassword = keystoreProperties.getProperty("keyPassword")
        }
    }

    defaultConfig {
        applicationId = "com.dahun.androidcleanarchitecturetemplate"
        minSdk = AppConfig.MIN_SDK_VERSION
        targetSdk = AppConfig.TARGET_SDK_VERSION
        versionCode = AppConfig.VERSION_CODE_PROD
        versionName = AppConfig.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            versionNameSuffix = "-debug"
        }
        create("inhouse") {
            initWith(getByName("release"))
            isDebuggable = true
            versionNameSuffix = "-inhouse"
            signingConfig = signingConfigs.getByName("release")
        }
    }
    flavorDimensions += "server"
    productFlavors {
        register("prod") {
            dimension = "server"
            versionCode = AppConfig.VERSION_CODE_PROD
            resValue("string", "app_name", AppConfig.APP_NAME_PROD)
        }

        register("dev") {
            dimension = "server"
            versionCode = AppConfig.VERSION_CODE_DEV
            versionNameSuffix = AppConfig.VERSION_NAME_DEV_SUFFIX
            resValue("string", "app_name", AppConfig.APP_NAME_DEV)
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":presentation"))

    implementationLibs(Dependencies.Android)
    implementationLibs(Dependencies.JetPack.Hilt)

    implementationLibs(Dependencies.JUnit)
    implementationLibs(Dependencies.Espresso)
    implementationLibs(Dependencies.MockK)
}