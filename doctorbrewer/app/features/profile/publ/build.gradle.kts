plugins {
    id("java-library")
    id( "kotlin")
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:${Lib.Kotlin.version}")


}