import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
   `kotlin-dsl`
}
group = "com.blank.wallpaper.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidApp"){
            id = "shayan.android.app"
            implementationClass = "plugins.AndroidApplicationConventionPlugin"
        }
        register("androidCompose"){
            id = "shayan.android.compose"
            implementationClass = "plugins.AndroidComposeConventionPlugin"
        }
        register("androidLibrary"){
            id = "shayan.android.lib"
            implementationClass = "plugins.AndroidLibConventionPlugin"
        }
        register("androidComposeLibrary"){
            id = "shayan.android.compose.library"
            implementationClass = "plugins.AndroidLibComposeConventionPlugin"
        }
        register("androidHilt"){
            id = "shayan.android.hilt"
            implementationClass = "plugins.AndroidHiltConventionPlugin"
        }


    }
}