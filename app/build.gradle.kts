plugins {
    id("shayan.android.app")
    id("shayan.android.compose")
    id("shayan.android.hilt")
}

android {
    namespace = "com.shayan.conventionmodular"
    defaultConfig {
        applicationId = "com.shayan.conventionmodular"
    }
}

dependencies {
    implementation(project(":feature:home:presentation"))
    implementation(project(":feature:profile:presentation"))
    implementation(libs.compose.navigation)


}
