plugins {
    id("shayan.android.lib")
    id("shayan.android.compose.library")
    id("shayan.android.hilt")
}

android {
    namespace = "com.shayan.presentation"

}

dependencies {
    implementation(project(":feature:home:data"))
    implementation(project(":feature:home:domain"))
    implementation(project(":core:common"))
}