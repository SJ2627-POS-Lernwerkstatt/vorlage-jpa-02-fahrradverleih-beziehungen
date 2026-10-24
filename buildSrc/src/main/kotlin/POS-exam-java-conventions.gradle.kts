import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    java
    jacoco
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
    withSourcesJar()
    withJavadocJar()
}

tasks.withType<Javadoc> {
    // Configures the underlying Javadoc tool options
    options {
        this as StandardJavadocDocletOptions
        // Prevents the build from failing on minor formatting/tag syntax errors
        addStringOption("Xdoclint:none", "-quiet")
        encoding = "UTF-8"
        charSet = "UTF-8"
    }
}

val libs = the<org.gradle.accessors.dm.LibrariesForLibs>()

dependencies {
    "implementation"(libs.spring.boot.devtools)

    "implementation"(libs.spring.boot.starter.validation)

    "testImplementation"(libs.spring.boot.starter.validation.test)

    "testRuntimeOnly"(libs.junit.platform.launcher)
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

// Disabling repackaging step for exams
tasks.named<BootJar>("bootJar") {
    enabled = false
}
