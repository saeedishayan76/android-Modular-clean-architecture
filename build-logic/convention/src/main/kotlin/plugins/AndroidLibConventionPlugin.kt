package plugins

import com.android.build.api.dsl.LibraryExtension
import com.shayan.convention.extensions.configureBuildTypes
import com.shayan.convention.versionCatalog
import extensions.configureAndroidKotlin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import java.awt.AWTEventMulticaster.add


class AndroidLibConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
               // apply("kotlin-android")
            }

            extensions.configure<LibraryExtension> {
                configureAndroidKotlin(this)
                defaultConfig.targetSdk = 33
                configureBuildTypes(this)
            }
            dependencies {
                "implementation"(versionCatalog().findLibrary("androidx.ktx.core").get())
                "implementation"(versionCatalog().findLibrary("androidx.lifecycle.runtime.ktx").get())
            }
        }
    }


}