plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("android.extensions")
    id("kotlin-android")
    id("kotlin-kapt")
}
apply(from = "$rootDir/ktlint.gradle")

android {

    compileSdk = Config.App.compileSdkVersion
    buildToolsVersion = Config.App.buildToolsVersion

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Lib.AndroidX.Compose.version
    }


    defaultConfig {
        applicationId = Config.App.applicationId
        minSdk = Config.App.minSdkVersion
        targetSdk = Config.App.targetSdkVersion
        versionCode = Config.App.versionCode
        versionName = Config.App.versionName
        testInstrumentationRunner = Config.App.testInstrumentationRunner
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
        }

        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    packagingOptions {
        resources.excludes.add("META-INF/DEPENDENCIES")
        resources.excludes.add("META-INF/LICENSE")
        resources.excludes.add("META-INF/LICENSE.txt")
        resources.excludes.add("META-INF/license.txt")
        resources.excludes.add("META-INF/NOTICE")
        resources.excludes.add("META-INF/NOTICE.txt")
        resources.excludes.add("META-INF/notice.txt")
        resources.excludes.add("META-INF/ASL2.0")
        resources.excludes.add("META-INF/*.kotlin_module")
    }
}
kapt {
    correctErrorTypes = true
}

dependencies {

    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation(project(mapOf("path" to ":app:features:profile:impl")))
    implementation(project(mapOf("path" to ":app:features:profile:publ")))
    implementation(project(mapOf("path" to ":core")))

    implementation(Lib.AndroidX.Compose.composeUi)
    implementation(Lib.AndroidX.Compose.materialCompose)
    implementation(Lib.AndroidX.Compose.toolingPreview)
    debugImplementation(Lib.AndroidX.Compose.tooling)
    implementation(Lib.AndroidX.Compose.activityCompose)

    implementation(Lib.Core.ktx)
    implementation(Lib.AndroidX.AppCompat.appcompat)
    implementation(Lib.Material.material)
    implementation(Lib.AndroidX.Lifecycle.runtime)

    implementation(Lib.Kotlin.stdlib)

    implementation(Lib.HiltDagger.hilt)
    kapt(Lib.HiltDagger.compiler)

    implementation (Lib.Room.runtime)
    kapt (Lib.Room.compiler)

}