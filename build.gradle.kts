import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.0-SNAPSHOT"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	id("org.asciidoctor.convert") version "1.5.8"
	kotlin("jvm") version "1.3.72"
	kotlin("plugin.spring") version "1.3.72"
	kotlin("plugin.jpa") version "1.3.72"
	kotlin("kapt") version "1.3.72"
}

group = "me.giorgirokhadze"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

val snippetsDir by extra { file("build/generated-snippets") }

dependencies {
	val kapt by configurations

	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.liquibase:liquibase-core")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("io.github.microutils:kotlin-logging:1.7.10")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	runtimeOnly("org.postgresql:postgresql")
	runtimeOnly("io.r2dbc:r2dbc-postgresql")
	kapt("org.springframework.boot:spring-boot-configuration-processor")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage")
	}
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("org.springframework.restdocs:spring-restdocs-webtestclient")
	testImplementation("org.springframework.security:spring-security-test")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.boot.experimental:spring-boot-bom-r2dbc:0.1.0.M3")
	}
}

tasks {
	withType<Test> {
		useJUnitPlatform()
	}

	withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "11"
		}
	}

	test {
		outputs.dir(snippetsDir)
	}

	asciidoctor {
		inputs.dir(snippetsDir)
		dependsOn(test)
	}
}
