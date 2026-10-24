import org.gradle.api.internal.artifacts.dsl.dependencies.DependenciesExtensionModule.module
import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel

plugins {
    idea
}

repositories {
    mavenLocal()
    mavenCentral()
}

idea {
    module {
        isDownloadSources = true
        isDownloadJavadoc = true
    }
    project {
        languageLevel = IdeaLanguageLevel(JavaVersion.VERSION_25)
    }
}

allprojects {
    group = "at.spengergasse"
    version = "1.0-SNAPSHOT"
}
