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

package github.nisrulz.androidutils.ktx.graphic

import android.graphics.Bitmap
import android.support.annotation.IntRange
import java.io.ByteArrayOutputStream


fun Bitmap.convertPngToByteArray(): ByteArray? {
    return this.convertToByteArray(Bitmap.CompressFormat.PNG, 80)
}

fun Bitmap.convertJpegToByteArray(): ByteArray? {
    return this.convertToByteArray(Bitmap.CompressFormat.JPEG, 80)
}

fun Bitmap.convertToByteArray(format: Bitmap.CompressFormat, @IntRange(from = 0, to = 100) quality: Int): ByteArray? {
    val byteArrayOutputStream = ByteArrayOutputStream()
    this.compress(format, quality, byteArrayOutputStream)
    return byteArrayOutputStream.toByteArray()
}