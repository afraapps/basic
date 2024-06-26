pluginManagement {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev/") }
        gradlePluginPortal()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenLocal()
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://androidx.dev/storage/compose-compiler/repository/") }
        maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev/") }
        maven {
            credentials {
                username = "android_repo_user"
                password = "andRo!dREp@o"
            }
            // isAllowInsecureProtocol = true
            url = uri("sftp://185.142.157.95:22/home/android_repo_user/maven2")
        }
    }

    /*versionCatalogs {
        create("ktor") {
            from(files("gradle/ktor.versions.toml"))
        }
    }*/
}

rootProject.name = "basic-kt"
include(":library")
