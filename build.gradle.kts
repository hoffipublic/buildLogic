// forcing the precompiled script plugins here to make it part of the Kotlin source set like any other class.
// Henceforth, the composite module as part of the project build is responsible for the configuration,
// which we usually do in the project-level Gradle build script.
// Therefore, we move the Gradle-specific declarations here.
// Precompiled script plugins are basically XXX.gradle.kts Kotlin scripts that can be placed together with other Kotlin source sets (src/main/kotlin ).
// Precompiled scripts have accessors, and don’t need extensions (Project.xxx) to be added, like Binary plugins.
plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
    google()
}

dependencies {
    // val libs and its values defined in ROOT/buildLogic/src/main/kotlin/VersionCatalogsExtensions.kt
    implementation(libs.kotlin.gradlePlugin)
    implementation("com.github.ben-manes:gradle-versions-plugin:${libs.versions.gradle.versions.plugin.get()}")
    implementation("nl.littlerobots.vcu:plugin:${libs.versions.gradle.versions.catalogUpdate.get()}")
    implementation("se.ascp.gradle:gradle-versions-filter:${libs.versions.gradle.versions.filter.get()}")
}
