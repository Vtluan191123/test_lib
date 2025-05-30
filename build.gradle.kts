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
	archiveClassifier = ""
}

val groupId = "com.github.vtluan191123"
val artifactId = "test_lib"
val version = "1.0.0"

group = groupId
this.version = version

java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(17))
	}
	withSourcesJar()
	withJavadocJar()
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

tasks.withType<Test> {
	useJUnitPlatform()
}

publishing {
	publications {
		create<MavenPublication>("mavenJava") {
			from(components["java"])
			groupId = groupId
			artifactId = artifactId
			version = version
		}
	}
	repositories {
		// Thường không cần cấu hình repository này nếu chỉ dùng JitPack (JitPack tự build)
		// Nhưng bạn có thể để nếu cần publish trực tiếp
		maven {
			url = uri("https://jitpack.io")
		}
	}
}

tasks.javadoc {
	options {
		// Tắt cảnh báo thiếu javadoc khi build
		(this as StandardJavadocDocletOptions).addStringOption("Xdoclint:all,-missing", "-quiet")
	}
}
