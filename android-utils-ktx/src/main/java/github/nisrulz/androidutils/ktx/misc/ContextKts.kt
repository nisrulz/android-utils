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

import android.Manifest.permission
import android.content.Context
import android.net.ConnectivityManager
import android.support.annotation.ColorRes
import android.support.annotation.RequiresPermission
import android.support.annotation.StringRes
import android.support.v4.content.ContextCompat
import android.webkit.CookieManager
import android.webkit.CookieSyncManager

@RequiresPermission(permission.ACCESS_NETWORK_STATE)
fun Context.isConnectedToNetwork(): Boolean {
    val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectivityManager.activeNetworkInfo
    return activeNetworkInfo?.isConnected ?: false
}

fun Context.getStringRes(@StringRes resId: Int): String {
    return this.getString(resId) ?: ""
}

fun Context.getColor(@ColorRes colorId: Int): Int {
    return ContextCompat.getColor(this, colorId)
}

fun Context.syncCookieWithSystemBrowser() {
    if (VersionUtils.isLollipopOrUp()) {
        CookieManager.getInstance().flush()
    } else {
        CookieSyncManager.createInstance(this)
        CookieSyncManager.getInstance().startSync()
        CookieSyncManager.getInstance().sync()
    }
}

