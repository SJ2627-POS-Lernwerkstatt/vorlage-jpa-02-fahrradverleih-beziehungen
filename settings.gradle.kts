rootProject.name = "POS_exam_java_seed"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    //repositoriesMode = RepositoriesMode.PREFER_SETTINGS
    repositories {
        mavenLocal()
        mavenCentral()
    }
}

include("Aufgabe1_ORMapping")
