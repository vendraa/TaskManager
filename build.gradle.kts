@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.daggerHilt) apply false
    alias(libs.plugins.kotlinKapt) apply false
    alias(libs.plugins.kotlinParcelize) apply false
    alias(libs.plugins.androidLibrary) apply false
}
true