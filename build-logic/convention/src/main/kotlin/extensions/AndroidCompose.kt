package extensions
/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import com.android.build.api.dsl.CommonExtension
import com.shayan.convention.versionCatalog
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *>
) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = versionCatalog().findVersion("androidxComposeCompiler").get().toString()
        }

        dependencies {
            add("implementation",platform(versionCatalog().findLibrary("androidx.composeBom").get()))
            add("implementation",versionCatalog().findBundle("compose").get())
            add("implementation",versionCatalog().findLibrary("androidx.activityCompose").get())
            add("implementation",versionCatalog().findLibrary("androidx.composeMaterial3").get())
            // Add ComponentActivity to debug manifest
            // Screenshot Tests on JVM
        }

    }


}


