plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.10"
    id("org.jetbrains.kotlin.kapt") version "1.6.10"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.6.10"
    id("com.github.johnrengelman.shadow") version "7.1.1"
    id("io.micronaut.application") version "3.2.1"
}

version = "0.1"
group = "io.micronaut.data.issue"

val kotlinVersion = project.properties.get("kotlinVersion")
val kotlinCoroutinesReactive = project.properties.get("kotlinCoroutinesReactive")
repositories {
    mavenCentral()
}

dependencies {
    kapt("io.micronaut:micronaut-http-validation")
    kapt("io.micronaut.data:micronaut-data-processor")

    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("jakarta.annotation:jakarta.annotation-api")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    runtimeOnly("ch.qos.logback:logback-classic")
    implementation("io.micronaut:micronaut-validation")

    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")

    //r2dbc and hibernate anotations
    implementation("io.micronaut.data:micronaut-data-r2dbc")
    implementation("io.micronaut.r2dbc:micronaut-r2dbc-core")
    implementation("io.r2dbc:r2dbc-pool:0.8.7.RELEASE")
    implementation("io.r2dbc:r2dbc-h2")

    implementation("io.micronaut.flyway:micronaut-flyway")
    implementation("io.micronaut.sql:micronaut-jdbc-hikari")

    //Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactive:${kotlinCoroutinesReactive}")
    implementation( "org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:${kotlinCoroutinesReactive}")

    //general
    implementation("commons-lang:commons-lang:2.6")

    //dns Mac M1
    // https://mvnrepository.com/artifact/io.netty/netty-resolver-dns-native-macos
    implementation("io.netty:netty-resolver-dns-native-macos:4.1.72.Final:osx-aarch_64")
}


application {
    mainClass.set("io.micronaut.data.issue.ApplicationKt")
}
java {
    sourceCompatibility = JavaVersion.toVersion("11")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
            javaParameters = true
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
            javaParameters = true
        }
    }
}

graalvmNative.toolchainDetection.set(false)
micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("io.micronaut.data.issue.*")
    }
}

