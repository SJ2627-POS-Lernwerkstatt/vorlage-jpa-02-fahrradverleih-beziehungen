pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

// Downloads JDK 25 automatically if it is not installed locally.
// No version: the root settings already put the plugin on the classpath.
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention")
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}
