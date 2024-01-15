plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.telegram:telegrambots:6.8.0")

    implementation("com.google.code.gson:gson:2.3.1")
    implementation("net.java.dev.jna:jna-platform:5.12.1")
    implementation("com.github.downgoon:MarvinFramework:1.5.5")

    implementation("org.xerial:sqlite-jdbc:3.7.2")

    implementation("net.java.dev.jna:jna-platform:5.12.1")
    implementation("org.json:json:20171018")

}

tasks.test {
    useJUnitPlatform()
}