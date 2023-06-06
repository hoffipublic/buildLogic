plugins {
    id("kotlinCommonBuildLogic") // local in ROOT/buildLogic/src/main/kotlin/kotlinCommonBuildLogic.gradle.kts
    kotlin("multiplatform")
    // add gradle plugins here that "automagically should be applied
    // and then in YOUR build.gradle.kts reference:  plugins { id(<thisFileName>) }
}

// you may configure stuff of plugins that you imported above

kotlin {
    jvmToolchain(BuildLogicGlobal.jdkVersion)
}

//task("testUnitTest") {
//    dependsOn("test")
//}

dependencies {

}

