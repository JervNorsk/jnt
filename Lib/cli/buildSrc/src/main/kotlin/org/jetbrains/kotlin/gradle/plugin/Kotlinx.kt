import org.gradle.api.Project
import org.gradle.kotlin.dsl.extra

fun Project.kotlinx(module: String, version: String): String =
    "org.jetbrains.kotlinx:kotlinx-$module:$version"
