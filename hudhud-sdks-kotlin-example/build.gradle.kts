plugins {
    id("hudhud-sdks.kotlin")
    application
}

dependencies {
    implementation(project(":hudhud-sdks-kotlin"))
}

application {
    // Use `./gradlew :hudhud-sdks-kotlin-example:run` to run `Main`
    // Use `./gradlew :hudhud-sdks-kotlin-example:run -Dexample=Something` to run `SomethingExample`
    mainClass = "sa.hudhud.api.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}ExampleKt"
        else
            "MainKt"
    }"
}
