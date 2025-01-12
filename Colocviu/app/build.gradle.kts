plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.colocviu"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.colocviu"
        minSdk = 26
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

    kotlinOptions {
        jvmTarget = "11"
    }

    viewBinding {
        enable = true
    }
}

dependencies {
    // AndroidX AppCompat
    implementation("androidx.appcompat:appcompat:1.7.0-alpha03")
    implementation("com.squareup.picasso:picasso:2.71828")
    // AndroidX Fragment
    implementation("androidx.fragment:fragment-ktx:1.6.1")

    // Compose (dacă este utilizat)
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material:material")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation(libs.androidx.recyclerview)
    debugImplementation("androidx.compose.ui:ui-tooling")

    // Retrofit și Gson (pentru API)
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Lifecycle (opțional, pentru ViewModel sau LiveData)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")

    // Testare
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
