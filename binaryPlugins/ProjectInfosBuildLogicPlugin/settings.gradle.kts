rootProject.name = "ProjectInfosBuildLogicPlugin"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            val libsVersionsRootDir = File(File(rootProject.projectDir.parent + "/../..").canonicalPath)
            val libsVersionsTomlLocation = "/gradle/libs.versions.toml"
            val rootDirGradleLibsVersionsToml = File(libsVersionsRootDir, libsVersionsTomlLocation)
            if (rootDirGradleLibsVersionsToml.exists()) {
                logger.lifecycle("-> using version information on dependencies inside '${libsVersionsRootDir.name}${libsVersionsTomlLocation}' for ${rootProject.name} ")
            } else {
                throw GradleException(rootProject.name + ": did not find version information on dependencies inside 'ROOT${libsVersionsTomlLocation}'")
            }
            // use gradle/libs.versions.toml from root project instead of this composite build
            from(files(rootDirGradleLibsVersionsToml.absolutePath)) // in rootProject folder
        }
    }
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS) // FAIL_ON_PROJECT_REPOS or PREFER_PROJECT or PREFER_SETTINGS)
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
    }
}