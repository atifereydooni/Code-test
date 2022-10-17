buildscript {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath(ClassPaths.buildTools)
        classpath(ClassPaths.kotlin)
        classpath(ClassPaths.hilt)
        classpath(ClassPaths.ktLint)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
    }
}

tasks.register("clean").configure {
    delete("build")
}

subprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions.freeCompilerArgs += listOf(
            "-Xopt-in=androidx.compose.material.ExperimentalMaterialApi",
            "-Xopt-in=androidx.compose.animation.ExperimentalAnimationApi"
        )
    }
}