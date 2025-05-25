import com.android.build.api.dsl.androidLibrary
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinComposePlugin)
    alias(libs.plugins.kotlinComposeMultiplatform)
    // ------------------------------------------------------------------------
    alias(libs.plugins.androidApplication)
//    alias(libs.plugins.androidLibraryKMP)
}

dependencies {
    debugImplementation(compose.uiTooling)
}

kotlin {
//    androidLibrary { // TODO: REQUIRE DEDICATED PLUGIN WITH COMPOSE RESOLUTION
//        experimentalProperties["android.experimental.kmp.enableAndroidResources"] = true
//
//        namespace = project.group.toString()
//        compileSdk = libs.versions.android.compileSdk.get().toInt()
//        minSdk = libs.versions.android.minSdk.get().toInt()
//    }
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(libs.google.android.material)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

compose {
    resources {
        packageOfResClass = "${group}.assets"
        customDirectory(
            sourceSetName = "commonMain",
            directoryProvider = provider { layout.projectDirectory.dir("src").dir("commonMain").dir("assets") }
        )
    }
}

android {
    namespace = project.group.toString()
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "${project.group}.${name}"
        versionName = "${project.version}"
        versionCode = 1

        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
//    buildTypes {
//        release {
//            isMinifyEnabled = false
//        }
//    }
//    buildFeatures {
//        prefab = true
//    }
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_11
//        targetCompatibility = JavaVersion.VERSION_11
//    }
}
