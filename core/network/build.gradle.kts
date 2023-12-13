
plugins {
    id("shayan.android.lib")
    id("shayan.android.hilt")
}

android {
    namespace = "com.shayan.network"

}

dependencies {
    api(libs.retrofit.android)
    api(libs.retrofit.gson.android)
}