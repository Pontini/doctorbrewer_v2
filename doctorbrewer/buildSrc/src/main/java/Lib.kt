object Lib {
    object Kotlin {
        const val version = "1.5.21"

        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val coroutinesAdapter =
            "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
    }

    object AndroidX {

        object Navigation {
            private const val navigationVersion = "2.3.4"

            const val fragment = "androidx.navigation:navigation-fragment-ktx:$navigationVersion"
            const val ui = "androidx.navigation:navigation-ui-ktx:$navigationVersion"
        }

        object Lifecycle {
            private const val viewModelVersion = "2.0.0"
            private const val liveDataVersion = "2.3.0"

            const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$liveDataVersion"
            const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$viewModelVersion"

            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
        }

        object AppCompat {
            private const val version = "1.3.1"

            const val appcompat = "androidx.appcompat:appcompat:$version"
        }

        object ConstraintLayout {
            private const val version = "2.0.4"

            const val constraintLayout = "androidx.constraintlayout:constraintlayout:$version"
        }

        object Compose {
            const val version = "1.0.1"

            const val composeUi = "androidx.compose.ui:ui:$version"
            const val materialCompose = "androidx.compose.material:material:$version"
            const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
            const val activityCompose = "androidx.activity:activity-compose:1.3.1"
        }
    }

    object Core {
        private const val version = "1.6.0"
        const val ktx = "androidx.core:core-ktx:$version"
    }

    object Room {
        private const val roomVersion = "2.3.0"

        const val runtime = "androidx.room:room-runtime:$roomVersion"
        const val compiler = "androidx.room:room-runtime:$roomVersion"
    }

    object Material {
        private const val version = "1.4.0"

        const val material = "com.google.android.material:material:$version"
    }

    object LottieAnimation {
        private const val lottieVersion = "4.0.0"

        const val lottie = "com.airbnb.android:lottie:$lottieVersion"
    }

    object Retrofit {
        private const val version = "2.9.0"

        const val retrofit2 = "com.squareup.retrofit2:retrofit:$version"

    }

    object Gson {
        private const val version = "2.3.0"
        const val converterGson = "com.squareup.retrofit2:converter-gson:$version"
        const val scalarsGson = "com.squareup.retrofit2:converter-scalars:2.6.0"

    }

    object Okhttp {
        private const val version = "4.9.0"
        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
        const val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:4.7.2"
    }

    object Koin {
        private const val version = "3.1.2"

        const val koinCore = "io.insert-koin:koin-core:$version"
        const val koinTest = "io.insert-koin:koin-test:$version"
        const val koinAndroid = "io.insert-koin:koin-android:$version"
        const val extAndroid = "io.insert-koin:koin-android-ext:$version"
    }

    object Glide {
        private const val version = "4.11.0"
        const val glide = "com.github.bumptech.glide:glide:$version"
    }

    object HiltDagger {
        const val version = "2.39.1"

        const val hilt = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-compiler:$version"

    }
}

