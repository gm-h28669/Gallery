import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.konan.properties.Properties
import java.io.FileInputStream


plugins {
    alias(libs.plugins.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.detekt)
}

val keystorePropertiesFile: File = rootProject.file("keystore.properties")
val keystoreProperties = Properties()
if (keystorePropertiesFile.exists()) {
    keystoreProperties.load(FileInputStream(keystorePropertiesFile))
}

android {
    compileSdk = libs.versions.appBuildCompileSdkVersion.get().toInt()

    defaultConfig {
        applicationId = libs.versions.appVersionAppId.get()
        minSdk = libs.versions.appBuildMinimumSdk.get().toInt()
        targetSdk = libs.versions.appBuildTargetSdk.get().toInt()
        versionName = libs.versions.appVersionVersionName.get()
        versionCode = libs.versions.appVersionVersionCode.get().toInt()
    }

    signingConfigs {
        if (keystorePropertiesFile.exists()) {
            register("release") {
                keyAlias = keystoreProperties.getProperty("keyAlias")
                keyPassword = keystoreProperties.getProperty("keyPassword")
                storeFile = file(keystoreProperties.getProperty("storeFile"))
                storePassword = keystoreProperties.getProperty("storePassword")
            }
        }
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            if (keystorePropertiesFile.exists()) {
                signingConfig = signingConfigs.getByName("release")
            }
        }
    }

    flavorDimensions += "licensing"
    productFlavors {
        register("foss")
        register("prepaid")
    }

    compileOptions {
        val currentJavaVersionFromLibs = JavaVersion.valueOf(libs.versions.appBuildJavaVersion.get())
        sourceCompatibility = currentJavaVersionFromLibs
        targetCompatibility = currentJavaVersionFromLibs
    }

    dependenciesInfo {
        includeInApk = false
    }

    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(
                // use the *same* name as in libs.versions.toml
                libs.versions.appBuildKotlinJvmTarget
                    .map { JvmTarget.fromTarget(it) }
                    .get()
            )
        }
    }

    namespace = libs.versions.appVersionAppId.get()

    lint {
        checkReleaseBuilds = false
        abortOnError = true
        warningsAsErrors = true
        baseline = file("lint-baseline.xml")
    }

    bundle {
        language {
            @Suppress("UnstableApiUsage")
            enableSplit = false
        }
    }
}

detekt {
    baseline = file("detekt-baseline.xml")
    ignoreFailures = true
}

dependencies {
    implementation(libs.fossify.commons)
    implementation(libs.android.image.cropper)
    implementation(libs.android.gif.drawable)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.media3.exoplayer)
    implementation(libs.androidx.print)
    implementation(libs.androidx.documentfile)
    implementation(libs.sanselan)
    implementation(libs.androidphotofilters)
    implementation(libs.androidsvg.aar)
    implementation(libs.gestureviews)
    implementation(libs.subsamplingscaleimageview)
    implementation(libs.androidx.swiperefreshlayout)
    implementation(libs.awebp)
    implementation(libs.apng)
    implementation(libs.avif.integration)
    implementation(libs.jxl.integration)
    implementation(libs.okio)
    implementation(libs.picasso) {
        exclude(group = "com.squareup.okhttp3", module = "okhttp")
    }
    compileOnly(libs.okhttp)

    ksp(libs.glide.compiler)
    implementation(libs.zjupure.webpdecoder)

    implementation(libs.bundles.room)
    ksp(libs.androidx.room.compiler)
}
