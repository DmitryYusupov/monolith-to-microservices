import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.5.0"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.5.10"
	kotlin("plugin.spring") version "1.5.10"
	kotlin("plugin.jpa") version "1.5.10"
	kotlin("plugin.allopen") version "1.3.61"
}

java.sourceCompatibility = JavaVersion.VERSION_14

allprojects {
	group = "ru.yusdm.monolithtomicro"
	version = "0.0.1-SNAPSHOT"

	repositories {
		mavenCentral()
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}

	tasks.withType<JavaCompile> {
		sourceCompatibility = "14"
		targetCompatibility = "14"
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "14"
		}
	}

}

subprojects {
	repositories {
		mavenCentral()
	}
	apply {
		plugin("org.jetbrains.kotlin.jvm")
	}
}