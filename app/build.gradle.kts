plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.devtools.ksp)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "me.hd.wexpt"
    compileSdk = 36

    defaultConfig {
        applicationId = "me.hd.wexpt"
        minSdk = 27
        targetSdk = 36
        versionCode = 3
        versionName = "1.0.2"
        buildConfigField("String", "APP_NAME", "\"WExpt\"")
    }
    androidResources {
        additionalParameters += listOf("--allow-reserved-package-id", "--package-id", "0x78")
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
    applicationVariants.all {
        outputs.all {
            val output = this as com.android.build.gradle.internal.api.BaseVariantOutputImpl
            output.outputFileName?.let { fileName ->
                if (fileName.endsWith(".apk")) {
                    val projectName = rootProject.name
                    val versionName = defaultConfig.versionName
                    output.outputFileName = "${projectName}_v${versionName}.apk"
                }
            }
        }
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
    implementation(libs.kotlinx.serialization.json)
}
