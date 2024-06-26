enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots/") }
    }
}

rootProject.name = "TaskManager"
include(":app")
include(":common:resources")
include(":common:theme")
include(":common:navigation")
include(":common:ui")
include(":common:utils")
include(":domain")
include(":data")
include(":screens")
include(":screens:main")
include(":screens:notes")
include(":screens:tasks")
include(":service")
