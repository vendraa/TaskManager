plugins {
    alias(libs.plugins.androidLibrary)
}

android {
    namespace = "com.example.taskmanager.resources"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }
}