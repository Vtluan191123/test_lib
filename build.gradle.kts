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
val version  = "1.0.0"

group = groupId

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
			groupId = groupId   // Sử dụng biến cho groupId
			artifactId = artifactId  // Sử dụng biến cho artifactId
			version = version  // Sử dụng biến cho version
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
