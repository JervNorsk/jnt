rootProject.apply {
    name = "jnt-application"

    // ------------------------------------------------------------------------
    // Modules
    // ------------------------------------------------------------------------
    projectDir
        .listFiles()
        ?.filter { it -> it.isDirectory }
        ?.filter { it -> it.name in arrayOf("modules") }
        ?.forEach {
            it.listFiles()
                ?.forEach { file ->
                    include(":${file.name}")
                    project(":${file.name}").apply {
                        projectDir = file
                    }
                }
        }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}
