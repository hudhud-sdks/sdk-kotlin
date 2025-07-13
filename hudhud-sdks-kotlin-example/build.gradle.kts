plugins {
    id("hudhud-sdks.kotlin")
    application
}

dependencies {
    implementation(project(":hudhud-sdks-kotlin"))
}

application {
    mainClass = "com.hudhud_sdks.api.example.MainKt"
}
