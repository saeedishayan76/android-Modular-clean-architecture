pluginManagement {
    repositories {
        google()
        maven(
            uri("https://maven.google.com")
        )
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    includeBuild("build-logic")

}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        maven(
            uri("https://maven.google.com")
        )
        google()
        maven(
            uri("https://maven.google.com")
        )
        google()
        mavenCentral()
    }
}
rootProject.name = "OkConventionModularApp"
include(":app")
include(":feature:home:data")
include(":core:network")
include(":feature:home:domain")
include(":core:common")
include(":feature:home:presentation")
include(":feature:profile:data")
include(":feature:profile:presentation")
include(":feature:profile:domain")
include(":core:database")
include(":appNiaCatalog")
