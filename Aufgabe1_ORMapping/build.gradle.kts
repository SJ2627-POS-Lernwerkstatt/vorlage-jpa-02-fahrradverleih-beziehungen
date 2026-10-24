plugins {
    id("POS-exam-java-conventions")
}

description = "aufgabe1_ormapping"

dependencies {
    implementation(libs.spring.boot.starter.data.jpa)

    testImplementation(libs.spring.boot.starter.data.jpa.test)

    runtimeOnly(libs.h2)
}
