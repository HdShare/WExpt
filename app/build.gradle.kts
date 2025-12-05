plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.devtools.ksp)
}

android {
    namespace = "me.hd.wexpt"
    compileSdk = 36

    defaultConfig {
        applicationId = "me.hd.wexpt"
        minSdk = 27
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
        buildConfigField("String", "APP_NAME", "\"WExpt\"")
    }

    buildFeatures {
        buildConfig = true
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    packaging {
        resources.excludes.addAll(
            arrayOf(
                "kotlin/**",
                "META-INF/**",
                "**.bin",
                "kotlin-tooling-metadata.json"
            )
        )
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation(libs.annotation)
    compileOnly(libs.xposed.api)
    implementation(libs.yukihookapi.api)
    ksp(libs.yukihookapi.ksp.xposed)
    implementation(libs.kavaref.core)
    implementation(libs.kavaref.extension)
}
