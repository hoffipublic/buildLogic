plugins {
    id("kotlinCommonBuildLogic")
    kotlin("jvm")
    // add gradle plugins here that "automagically should be applied
    // and then in YOUR build.gradle.kts reference:  plugins { id(<thisFileName>) }
}

//apply(from = "${project.projectDir}/${"buildLogic"}/src/main/kotlin/BuildLogicGlobalCommon.gradle.kts")

// you may configure stuff of plugins that you imported above

kotlin {
    jvmToolchain(BuildLogicGlobal.jdkVersion)
}
afterEvaluate {
    tasks {
        named<JavaExec>("run") {
            // needed if App wants to read from stdin
            standardInput = System.`in`
        }
    }
}

//task("testUnitTest") {
//    dependsOn("test")
//}

dependencies {

}
