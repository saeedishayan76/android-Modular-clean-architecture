@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("shayan.android.lib")
    id("shayan.android.hilt")
}

android {
    namespace = "com.shayan.data"
}

dependencies {

    implementation(project(":core:network"))
}