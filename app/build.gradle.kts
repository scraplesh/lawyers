@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    defaultConfig {
        applicationId = AndroidConfig.applicationId
        resValue("string", "app_name", "Lawyers")
    }

    buildFeatures {
        buildConfig = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.5"
    }

    signingConfigs {
        getByName("debug") {
            storeFile = file("../signing/debug.jks")
            storePassword = "android"
            keyAlias = "androiddebugkey"
            keyPassword = "android"
        }
    }

    buildTypes {
        getByName("debug") {
            signingConfig = signingConfigs.getByName("debug")
            applicationIdSuffix = ".debug"
        }
    }
}

dependencies {
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core)
    implementation(libs.compose.foundation.core)
    implementation(libs.compose.material.core)
    implementation(libs.compose.runtime)
    implementation(libs.compose.ui.core)
    implementation(libs.compose.ui.tooling)
    implementation(libs.google.material)
    implementation(libs.lifecycle.runtime)
    implementation(project(Shared.uikit))
}
