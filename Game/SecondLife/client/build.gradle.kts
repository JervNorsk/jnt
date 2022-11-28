plugins {
    kotlin("multiplatform")
}

configure(allprojects) {
    group = extra["project.group"] as String
    version = extra["project.version"] as String
}

kotlin {
    jvm()
    sourceSets {
        val commonMain by getting {
            resources.srcDir(file("src/firestormMain/lsl"))
        }
    }
}
