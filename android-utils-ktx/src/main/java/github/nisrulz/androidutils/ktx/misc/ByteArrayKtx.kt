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

package github.nisrulz.androidutils.ktx.misc

import android.graphics.BitmapFactory
import java.io.File
import java.io.FileOutputStream


fun ByteArray.saveFile(path: String) {
    val file = File(path)
    if (!file.exists()) {
        file.createNewFile()
    }
    val output = FileOutputStream(file)
    output.write(this)
    output.flush()
    output.close()
}

fun ByteArray.toBitmap(opts: BitmapFactory.Options? = null) = BitmapFactory.decodeByteArray(this, 0, size, opts)

fun ByteArray.toHex(): String {
    var des = ""
    var tmp: String
    for (i in this.indices) {
        tmp = Integer.toHexString(this[i].toInt() and 0xFF)
        if (tmp.length == 1) {
            des += "0"
        }
        des += tmp
    }
    return des
}