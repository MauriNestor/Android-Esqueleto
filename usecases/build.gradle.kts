plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.ksp)
}
sourceSets {
    named("main") {
        java.srcDir("build/generated/ksp/main/kotlin")
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_22
    targetCompatibility = JavaVersion.VERSION_22
}
dependencies {
    implementation(project(":domain"))
    implementation(libs.koin.core)
    implementation(libs.koin.annotations)
    ksp(libs.koin.ksp.compiler)
}
