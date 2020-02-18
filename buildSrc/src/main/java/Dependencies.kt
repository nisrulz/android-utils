/*
 * Copyright (C) 2016 Nishant Srivastava
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

object Dependencies {

    // Kotlin
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"

    // Testing
    const val junit = "junit:junit:${Versions.junit}"
    const val androidJunitExt = "androidx.test.ext:junit:${Versions.junitExt}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val testRules = "androidx.test:rules:${Versions.testRules}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"

    // AndroidX
    const val andxAppCompat = "androidx.appcompat:appcompat:${Versions.andxAppcompat}"
    const val andxCore = "androidx.core:core:${Versions.andxCore}"
    const val andxFragment = "androidx.fragment:fragment-ktx:${Versions.andxFragment}"
    const val andxAnnotation = "androidx.annotation:annotation:${Versions.andxAnnoation}"
    const val andxConstraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.andxConstraintLayout}"
    const val andxLifecycleRuntime =
            "androidx.lifecycle:lifecycle-runtime:${Versions.andxLifecycleRuntime}"
    const val material = "com.google.android.material:material:${Versions.material}"

    // Network
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpInterceptor}"
}