apply {
    from("$rootDir/android-library-build.gradle")
}
dependencies {

    "implementation"(project(Modules.core))
    "implementation"(project(Modules.recipeInteractors))
    "implementation"(project(Modules.recipeDetailDomain))
    "implementation"(Coil.coil)
    "implementation"(Hilt.android)
    "kapt"(Hilt.compiler)
}