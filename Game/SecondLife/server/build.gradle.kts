plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("application")
    id("war")
}

configure(allprojects) {
    group = extra["project.group"] as String
    version = extra["project.version"] as String
}

kotlin {
    jvm {
        withJava()
        tasks.named<Test>("jvmTest") {
            useJUnit()
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
//              Ktor
//              ---------------------------------------------------------------
                implementation(ktor("server-core"))

//              Ktor Engine
//              ---------------------------------------------------------------
//                implementation(ktor("server-cio")) // No HTTP/2
//                implementation(ktor("server-netty"))
//                implementation(ktor("server-jetty"))
//                implementation(ktor("server-tomcat"))
                implementation(ktor("server-servlet"))

//              Ktor Logging
//              ---------------------------------------------------------------
                implementation(ktor("server-call-logging"))
                implementation("ch.qos.logback:logback-classic:${extra["logback.version"]}")
//                implementation("org.apache.logging.log4j:log4j-core:${extra["log4j.version"]}")
//                implementation("org.apache.logging.log4j:log4j-slf4j-impl:${extra["log4j.version"]}")

//              Ktor Plugins
//              ---------------------------------------------------------------
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
    }
}

application {
    mainClass.set("io.github.jervnorsk.toolkit.secondlife.server.MainKt")
}

afterEvaluate {
    tasks.getByName<War>("war") {
        webInf {
            from("src/jvmMain/webapp/WEB-INF")
        }
    }
}
