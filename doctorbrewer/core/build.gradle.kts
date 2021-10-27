plugins {
    id("java-library")
    id("kotlin")
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Lib.Kotlin.version}")

    implementation(Lib.Kotlin.coroutines)
    implementation(Lib.Kotlin.coroutinesAdapter)

    implementation(Lib.Kotlin.coroutines)

    implementation(Lib.HiltDagger.core)
    annotationProcessor(Lib.HiltDagger.compiler)
}