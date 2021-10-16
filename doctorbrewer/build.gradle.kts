buildscript{

    val kotlin_version by extra(Lib.Kotlin.version)
    repositories{
        google()
        mavenCentral()
    }
    dependencies{

        classpath("com.android.tools.build:gradle:7.0.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
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
