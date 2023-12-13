package extensions

import com.android.build.api.dsl.CommonExtension
import com.shayan.convention.versionCatalog
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal fun Project.configureAndroidKotlin(
    extension: CommonExtension<*, *, *, *, *>,
) {
    with(extension) {
        namespace = "com.shayan.network"
        compileSdk = 33
        defaultConfig.apply {
            minSdk = 24
            testInstrumentationRunner = "androidx.test.runner.AndroidJunitRunner"
            vectorDrawables.useSupportLibrary = true
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
        packaging.resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"

        dependencies {
            add("implementation", versionCatalog().findLibrary("androidx.ktx.core").get())
            add(
                "implementation",
                versionCatalog().findLibrary("androidx.lifecycle.runtime.ktx").get()
            )
        }
    }
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_17.toString()
            freeCompilerArgs = freeCompilerArgs + listOf("-Xopt-in=kotlin.RequiresOptIn")
        }
    }
}