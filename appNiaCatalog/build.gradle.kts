@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("shayan.android.app")
    id("shayan.android.compose")
    id("shayan.android.hilt")
}

android {
    namespace = "com.shayan.appniacatalog"
    defaultConfig {
        applicationId = "com.shayan.conventionmodular"
    }
}

dependencies {

}