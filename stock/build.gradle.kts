import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.1.8.RELEASE"
	id("io.spring.dependency-management") version "1.0.8.RELEASE"
	kotlin("jvm") version "1.2.71"
	kotlin("plugin.spring") version "1.2.71"
	kotlin("plugin.jpa") version "1.2.71"
}

group = "com.ecma"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation ("org.springframework.boot:spring-boot-starter-amqp")
	implementation ("org.springframework.cloud:spring-cloud-stream")
	implementation (group = "org.springframework.cloud", name = "spring-cloud-stream-binder-rabbit", version = "2.2.1.RELEASE")
	implementation(group = "org.springframework.boot", name = "spring-boot-starter-activemq", version = "2.1.9.RELEASE")
	implementation(group = "com.fasterxml.jackson.module", name = "jackson-module-kotlin", version = "2.10.1")
	implementation (group = "org.springframework.cloud", name = "spring-cloud-starter-sleuth", version = "2.1.5.RELEASE")
	implementation (group = "org.springframework.cloud", name = "spring-cloud-starter-kubernetes-all", version = "1.0.4.RELEASE")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation (group = "org.springframework.cloud", name = "spring-cloud-stream-test-support", version = "2.2.1.RELEASE")
	runtimeOnly ("com.h2database:h2")
	runtimeOnly ("org.hsqldb:hsqldb")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}
