rootProject.name = "POS_exam_java_seed"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

// Downloads JDK 25 automatically if it is not installed locally.
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

dependencyResolutionManagement {
    //repositoriesMode = RepositoriesMode.PREFER_SETTINGS
    repositories {
        mavenLocal()
        mavenCentral()
    }
}

include("Aufgabe1_ORMapping")
