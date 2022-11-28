rootProject.apply {
    name = "jnt-cli"
}

pluginManagement {
    resolutionStrategy {
        plugins {
            kotlin("multiplatform") version(extra["kotlin.version"] as String)
        }
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

include(":core")
project(":core").apply {
    projectDir = file("module/core")
}
include(":runtime:kotlin")
project(":runtime:kotlin").apply {
    projectDir = file("module/runtime/kotlin")
}
