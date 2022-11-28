rootProject.apply {
    name = "jnt-secondlife"
}

pluginManagement {
    resolutionStrategy {
        plugins {
            kotlin("multiplatform") version(extra["kotlin.version"] as String)
            kotlin("plugin.serialization") version(extra["kotlin.plugin.serialization.version"] as String)
        }
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

include("client")
include("server")
