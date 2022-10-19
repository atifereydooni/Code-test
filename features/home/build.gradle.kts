plugins {
    id(Plugins.library)
    id(Plugins.umainPlugin)
    id(Plugins.composePlugin)
}

android {
    defaultConfig {
        testInstrumentationRunner = "com.umain.home.TestAppJUnitRunner"
    }
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
    implementation(Dependencies.composeMaterial)

    kaptAndroidTest(Dependencies.hiltCompiler)
    androidTestImplementation(Dependencies.hiltAndroidTest)

    testImplementation(Dependencies.jUnit)
    testImplementation(Dependencies.coreTesting)
    testImplementation(Dependencies.mockk)
    testImplementation(Dependencies.liveDataTesting)
    testImplementation(Dependencies.coroutinesTest)

    kaptAndroidTest(Dependencies.hiltCompiler)
    androidTestImplementation(Dependencies.hiltAndroidTest)
    androidTestImplementation(Dependencies.jUnit)
    androidTestImplementation(Dependencies.composeTest)
    androidTestImplementation(Dependencies.coreTesting)
    androidTestImplementation(Dependencies.liveDataTesting)
    androidTestImplementation(Dependencies.espresso)
    androidTestImplementation(Dependencies.mockk_android)
}