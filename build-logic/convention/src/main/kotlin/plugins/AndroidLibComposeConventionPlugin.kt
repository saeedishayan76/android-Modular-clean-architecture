package plugins

import com.android.build.api.dsl.LibraryExtension
import com.shayan.convention.versionCatalog
import extensions.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidLibComposeConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            pluginManager.apply("com.android.library")
            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)
            dependencies {
                "implementation"(versionCatalog().findLibrary("androidx.hilt.navigation.compose").get())
            }
        }

    }
}