apply{
    from("$rootDir/library-build.gradle")
}
plugins{
    kotlin(KotlinPlugins.serialization) version Kotlin.version
    id(SqlDelight.plugin)
}
dependencies{
    "implementation"(project(Modules.recipeListDomain))
    "implementation"(project(Modules.recipeDetailDomain))
    "implementation"(Ktor.core)
    "implementation"(Ktor.clientSerialization)
    "implementation"(Ktor.android)

    "implementation"(SqlDelight.runtime)
}