buildscript{

    val kotlin_version by extra(Lib.Kotlin.version)
    repositories{
        google()
        jcenter()
    }
    dependencies{

        classpath("com.android.tools.build:gradle:7.0.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.10")
    }
}
allprojects {
    repositories {
        google()
        jcenter()
    }
}
tasks.create<Delete>("clean"){
    delete(rootProject.buildDir)
}
