@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://api.xposed.info") {
            content {
                includeGroup("de.robv.android.xposed")
            }
        }
        maven("https://raw.githubusercontent.com/HighCapable/maven-repository/main/repository/releases") {
            content {
                includeGroupByRegex("com\\.highcapable.*")
            }
        }
    }
}

rootProject.name = "WExpt"
include(":app")
