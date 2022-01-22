plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
}

dependencies {
    implementation(libs.compose.foundation.core)
    implementation(libs.compose.material.core)
    implementation(libs.compose.ui.core)
    implementation(libs.compose.ui.tooling)
    implementation(libs.google.accompanist.indicators)
    implementation(libs.google.accompanist.pager)
    implementation(project(Shared.uikit))
}