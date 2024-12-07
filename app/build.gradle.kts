plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.dagger.hilt)
}

android {
    namespace = "com.example.kiosk"
    compileSdk = 34

    viewBinding {
        enable = true
    }

    dataBinding {
        enable = true
    }

    defaultConfig {
        applicationId = "com.example.kiosk"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    // Android Basic Dependencies
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // Test Libraries
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)

    // OkHttp
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)

    // Glide
    implementation(libs.glide)
    annotationProcessor(libs.glide.compiler)

    // Dagger-Hilt
    implementation(libs.hilt.android)
    annotationProcessor(libs.hilt.compiler)

    implementation(libs.auto.value.annotations)
    annotationProcessor(libs.auto.value)

    implementation(libs.auto.value.parcel)
    annotationProcessor(libs.auto.value.parcel)
}