pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenLocal()
        google()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
    }
}

rootProject.name = "Gallery"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")

/*
// Path to the ROOT of the library's multi-module project
val libraryProjectPath = "../subsampling-scale-image-view"

// The lambda block after includeBuild is executed in the context
// of the build being included.
includeBuild(libraryProjectPath) {
    // Inside this lambda, 'this' refers to the Gradle instance for the included build.
    // So, project(":library") here refers to the :library module
    // within the subsampling-scale-image-view project.
    dependencySubstitution {
        substitute(module("org.fossify:subsampling-scale-image-view-debug:3.2.0"))
            .using(project(":library")) // This should now correctly resolve
        // to the :library module of the *included build*
    }
}
*/

