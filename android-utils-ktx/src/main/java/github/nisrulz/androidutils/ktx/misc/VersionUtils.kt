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

import android.os.Build.VERSION
import android.os.Build.VERSION_CODES

object VersionUtils {

    fun isApi(api: Int) = VERSION.SDK_INT == api

    fun isApiOrUp(api: Int) = VERSION.SDK_INT >= api

    fun isLollipop() = isApi(VERSION_CODES.LOLLIPOP)
    fun isMarshmallow() = isApi(VERSION_CODES.M)
    fun isNougat() = isApi(VERSION_CODES.N)
    fun isOreo() = isApi(VERSION_CODES.O)

    fun isLollipopOrUp() = isApiOrUp(VERSION_CODES.LOLLIPOP)
    fun isMarshmallowOrUp() = isApiOrUp(VERSION_CODES.M)
    fun isNougatOrUp() = isApiOrUp(VERSION_CODES.N)
    fun isOreoOrUp() = isApiOrUp(VERSION_CODES.O)
}