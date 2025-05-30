plugins {
	`java-library`
	`maven-publish`
	java
	id("org.springframework.boot") version "3.5.0"
	id("io.spring.dependency-management") version "1.1.7"
}

tasks.bootJar {
	enabled = false
}

tasks.jar {
	enabled = true
	archiveClassifier.set("")
}

val groupId = "com.github.vtluan191123"
val artifactId = "test_lib"
val versionLib = "1.0.1"

group = groupId
version = versionLib

java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(17))
	}
}

repositories {
	mavenCentral()
	maven { url = uri("https://jitpack.io") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

publishing {
	publications {
		create<MavenPublication>("mavenJava") {
			from(components["java"])
		}
	}
	repositories {
		maven {
			url = uri("https://jitpack.io")
		}
	}
}


tasks.withType<Test> {
	useJUnitPlatform()
}
