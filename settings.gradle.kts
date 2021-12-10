@file:Suppress("UnstableApiUsage")

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Lawyers"
enableFeaturePreview("VERSION_CATALOGS")

include(
    ":app",
    ":shared:uikit",
)
