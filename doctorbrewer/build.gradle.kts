buildscript{

    val kotlin_version by extra(Lib.Kotlin.version)
    repositories{
        google()
        mavenCentral()
    }
    dependencies{

        classpath("com.android.tools.build:gradle:7.0.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.39.1")

    }
}
allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
tasks.create<Delete>("clean"){
    delete(rootProject.buildDir)
}
