plugins {
    kotlin("multiplatform")
}
kotlin {
    jvm {
        withJava()
        tasks.named<Test>("jvmTest") {
            useJUnitPlatform()
            testLogging {
                events = setOf(
                    org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED,
                    org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED
                )
                exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL

                showExceptions = true
                showStandardStreams = true
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlinx("cli", "0.3.5"))
            }
        }
    }
}
