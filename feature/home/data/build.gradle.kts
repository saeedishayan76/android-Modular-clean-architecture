plugins {
    id("shayan.android.lib")
    id("shayan.android.hilt")
}

android {
    namespace = "com.shayan.data"
}

dependencies {
    implementation(project(":core:network"))
    implementation(project(":feature:home:domain"))
}