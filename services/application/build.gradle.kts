plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    // ------------------------------------------------------------------------
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.kotlinComposePlugin) apply false
    alias(libs.plugins.kotlinComposeMultiplatform) apply false
    // ------------------------------------------------------------------------
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
}

allprojects {
    group = "io.github.jervnorsk.jnt.application"
    version = "0.1.0"
}