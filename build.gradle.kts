@file:Suppress("UnstableApiUsage")

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        val libs = project.extensions.getByType<VersionCatalogsExtension>()
            .named("libs") as org.gradle.accessors.dm.LibrariesForLibs
        classpath(libs.plugin.android)
        classpath(libs.plugin.kotlin)
    }
}

subprojects {
    addKotlinCompilerFlags()
    forceDependencyVersions()
    afterEvaluate {
        extensions.findByType(com.android.build.gradle.TestedExtension::class.java)
            ?.apply {
                compileSdkVersion(AndroidConfig.compileSdkVersion)

                defaultConfig {
                    versionCode = AndroidConfig.versionCode
                    versionName = AndroidConfig.versionName
                    minSdk = AndroidConfig.minSdkVersion
                    targetSdk = AndroidConfig.targetSdkVersion
                }

                sourceSets.forEach { sourceSet ->
                    sourceSet.java.srcDir("src/${sourceSet.name}/kotlin")
                    sourceSet.java.srcDir("src/${sourceSet.name}/kotlinx")
                }

                with(compileOptions) {
                    sourceCompatibility = Versions.java
                    targetCompatibility = Versions.java
                }
            }
    }
}

fun Project.addKotlinCompilerFlags() {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = "11"
            kotlinOptions.freeCompilerArgs += listOf(
                "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi",
                "-Xjvm-default=all"
            )
        }
    }
}

fun Project.forceDependencyVersions() {
    fun MinimalExternalModuleDependency.stringRepresentation(): String {
        return "$module:${versionConstraint}"
    }

    configurations.all {
        resolutionStrategy {
            // FIXME: https://github.com/gradle/gradle/issues/17874
            force(libs.kotlin.get().stringRepresentation())
        }
    }
}

task("clean") {
    delete(rootProject.buildDir)
}
