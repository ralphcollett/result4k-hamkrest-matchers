val sonatypeUsername: String? by project
val sonatypePassword: String? by project

plugins {
    kotlin("jvm") version "1.5.31"
    `maven-publish`
    signing
    id("net.researchgate.release") version "2.8.1"
}

repositories {
    mavenCentral()
}

val junitVersion = "5.8.1"
val hamkrestVersion = "1.8.0.1"
val result4kVersion = "1.11.2.1"

dependencies {
    api("com.natpryce:hamkrest:$hamkrestVersion")
    api("dev.forkhandles:result4k:$result4kVersion")
    api(platform("dev.forkhandles:forkhandles-bom:$result4kVersion"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<GenerateModuleMetadata> {
    enabled = false
}

tasks {
    afterReleaseBuild { dependsOn(publish) }
}

java {
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = "result4k-hamkrest-matchers"
            from(components["java"])
            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }
            pom {
                name.set("result4k-hamkrest-matchers")
                description.set("Result4k Hamkrest matchers.")
                url.set("https://github.com/ralphcollett/result4k-hamkrest-matchers")
                developers {
                    developer {
                        id.set("ralph.collett")
                        name.set("Ralph Collett")
                        email.set("ralph.collett@gmail.com")
                    }
                }
                licenses {
                    license {
                        name.set("Apache License 2.0")
                        url.set("https://github.com/ralphcollett/result4k-hamkrest-matchers/blob/main/LICENSE")
                    }
                }
                scm {
                    connection.set("git@github.com:ralphcollett/result4k-hamkrest-matchers.git")
                }
            }
        }

    }
    repositories {
        maven {
            val releasesRepoUrl = "https://s01.oss.sonatype.org/content/repositories/releases/"
            val snapshotsRepoUrl = "https://s01.oss.sonatype.org/content/repositories/snapshots/"
            url = uri(if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl)
            credentials {
                username = sonatypeUsername
                password = sonatypePassword
            }
        }
    }
}

signing {
    sign(publishing.publications["mavenJava"])
}