plugins {
    id("com.android.library")
    id("kotlin-android")
}
apply(from = "$rootDir/ktlint.gradle")

android {
    compileSdk = 31

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Lib.AndroidX.Compose.version
    }

    defaultConfig {
        minSdk = 29
        targetSdk = 31
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {


    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")

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

}