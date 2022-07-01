plugins {
    kotlin("jvm") version "1.7.0"
    kotlin("plugin.dataframe")
}

group = "org.jetbrains.kotlinx"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:dataframe")
//    implementation(kotlin("stdlib"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

kotlin.sourceSets.getByName("main").kotlin.srcDir("build/generated/ksp/main/kotlin/")
kotlin.sourceSets.getByName("test").kotlin.srcDir("build/generated/ksp/test/kotlin/")

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
