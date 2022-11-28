plugins {
    kotlin("multiplatform")
    id("application")
}

configure(allprojects) {
    group = extra["project.group"] as String
    version = extra["project.version"] as String
}

kotlin {
    jvm()
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":core"))
                api(project(":runtime:kotlin"))
            }
        }
    }
}
