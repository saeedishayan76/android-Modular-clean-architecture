plugins {
    id("shayan.android.lib")
    id("shayan.android.compose.library")
    id("shayan.android.hilt")

}

android {
    namespace = "com.shayan.presentation"

}

dependencies {
    implementation(project(":feature:profile:data"))
    implementation(project(":feature:profile:domain"))
    implementation(project(":core:common"))

}