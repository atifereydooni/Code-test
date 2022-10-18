plugins {
    id(Plugins.library)
    id(Plugins.umainPlugin)
    id(Plugins.composePlugin)
}

dependencies {
    implementation(project(Modules.navigationModule))
    implementation(project(Modules.themeModule))

    implementation(Dependencies.retrofit)
    implementation(Dependencies.interceptor)
    api(Dependencies.converter)
    api(Dependencies.moshi)
    kapt(Dependencies.moshi_kapt)

    implementation(Dependencies.composeCoil)
}