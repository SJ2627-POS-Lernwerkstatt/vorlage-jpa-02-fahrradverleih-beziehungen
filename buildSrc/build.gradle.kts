plugins {
    java
    `kotlin-dsl`
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    // Expose the generated version-catalog accessor (LibrariesForLibs) to precompiled script plugins.
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))

    implementation("${libs.spring.boot.gradle.plugin.get()}")
    implementation("${libs.spring.dependency.management.gradle.plugin.get()}")
}
