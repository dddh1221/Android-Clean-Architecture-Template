import core.*

object Dependencies {

    object Coroutine: Libs {
        override fun getDependencies(): List<DependencyType> = listOf(
            DependencyType.Implementation(COROUTINES_CORE),
            DependencyType.Implementation(COROUTINES_ANDROID),
            DependencyType.TestImplementation(COROUTINES_TEST)
        )

        private const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINE}"
        private const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINE}"
        private const val COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINE}"
    }

    object Android: Libs {
        override fun getDependencies(): List<DependencyType> = listOf(
            DependencyType.Implementation(CORE_KTX),
            DependencyType.Implementation(APP_COMPAT),
            DependencyType.Implementation(LEGACY)
        )

        private const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
        private const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
        private const val LEGACY = "androidx.legacy:legacy-support-v4:${Versions.LEGACY}"
    }

    object Material: Libs {
        override fun getDependencies(): List<DependencyType> = listOf(
            DependencyType.Implementation(MATERIAL)
        )

        private const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    }

    object JetPack {

        object ConstraintLayout: Libs {
            override fun getDependencies(): List<DependencyType> = listOf(
                DependencyType.Implementation(CONSTRAINT_LAYOUT)
            )

            private const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
        }

        object Fragment: Libs {
            override fun getDependencies(): List<DependencyType> = listOf(
                DependencyType.Implementation(FRAGMENT_KTX)
            )

            private const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX}"
        }

        object LifeCycle: Libs {
            override fun getDependencies(): List<DependencyType> = listOf(
                DependencyType.Implementation(LIFECYCLE_VIEWMODEL_KTX),
                DependencyType.Implementation(LIFECYCLE_LIVEDATA_KTX),
                DependencyType.Implementation(LIFECYCLE_EXTENSIONS)
            )

            private const val LIFECYCLE_VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_KTX}"
            private const val LIFECYCLE_LIVEDATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE_KTX}"
            private const val LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:${Versions.LIFECYCLE_EXTENSION}"
        }

        object Navigation: Libs {
            override fun getDependencies(): List<DependencyType> = listOf(
                DependencyType.Implementation(NAVIGATION_FRAGMENT_KTX),
                DependencyType.Implementation(NAVIGATION_UI_KTX)
            )

            private const val NAVIGATION_FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
            private const val NAVIGATION_UI_KTX = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
        }

        object Paging: Libs {
            override fun getDependencies(): List<DependencyType> = listOf(
                DependencyType.Implementation(PAGING_KTX),
                DependencyType.Implementation(PAGING_ROOM)
            )

            private const val PAGING_KTX = "androidx.paging:paging-runtime-ktx:${Versions.PAGING}"
            private const val PAGING_ROOM = "androidx.room:room-paging:${Versions.ROOM}"
        }

        object Hilt: Libs {
            override fun getDependencies(): List<DependencyType> = listOf(
                DependencyType.Implementation(HILT_ANDROID),
                DependencyType.Kapt(HILT_COMPILER)
            )

            private const val HILT_ANDROID = "com.google.dagger:hilt-android:${Versions.HILT}"
            private const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
        }

        object Room: Libs {
            override fun getDependencies(): List<DependencyType> = listOf(
                DependencyType.Implementation(ROOM_RUNTIME),
                DependencyType.Kapt(ROOM_COMPILER),
                DependencyType.Implementation(ROOM_KTX)
            )

            private const val ROOM_RUNTIME = "androidx.room:room-runtime:${Versions.ROOM}"
            private const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"
            private const val ROOM_KTX = "androidx.room:room-ktx:${Versions.ROOM}"

        }
    }

    object SQLite: Libs {
        override fun getDependencies(): List<DependencyType> = listOf(
            DependencyType.Implementation(SQLITE)
        )

        private const val SQLITE = "org.xerial:sqlite-jdbc:${Versions.SQLITE}"
    }

    object Retrofit: Libs {
        override fun getDependencies(): List<DependencyType> = listOf(
            DependencyType.Implementation(GSON),
            DependencyType.Implementation(RETROFIT),
            DependencyType.Implementation(RETROFIT_CONVERTER_GSON),
            DependencyType.Implementation(OKHTTP3_LOGGING_INTERCEPTOR)
        )

        private const val GSON = "com.google.code.gson:gson:${Versions.GSON}"
        private const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
        private const val RETROFIT_CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
        private const val OKHTTP3_LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
    }

    object JUnit: Libs {
        override fun getDependencies(): List<DependencyType> = listOf(
            DependencyType.TestImplementation(JUNIT),
            DependencyType.AndroidTestImplementation(ANDROID_JUNIT)
        )

        private const val JUNIT = "junit:junit:${Versions.JUNIT}"
        private const val ANDROID_JUNIT = "androidx.test.ext:junit:${Versions.ANDROID_JUNIT}"
    }

    object Desugaring: Libs {
        override fun getDependencies(): List<DependencyType> = listOf(
            DependencyType.CoreLibraryDesugaring(DESUGARING)
        )

        private const val DESUGARING = "com.android.tools:desugar_jdk_libs:${Versions.DESUGARING}"
    }

    object Espresso: Libs {
        override fun getDependencies(): List<DependencyType> = listOf(
            DependencyType.AndroidTestImplementation(ESPRESSO)
        )

        private const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
    }

    object MockK: Libs {
        override fun getDependencies(): List<DependencyType> = listOf(
            DependencyType.TestImplementation(MOCKK)
        )

        private const val MOCKK = "io.mockk:mockk:${Versions.MOCKK}"
    }

}