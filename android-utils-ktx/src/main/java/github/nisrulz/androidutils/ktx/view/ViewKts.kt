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

package github.nisrulz.androidutils.ktx.view

import android.content.res.Resources
import android.support.annotation.DimenRes
import android.support.annotation.IntRange
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import github.nisrulz.androidutils.ktx.misc.VersionUtils

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun View.decreaseWidthByPercentage(@IntRange(from = 0, to = 100) percentageDecrease: Int) {
    val deviceWidth = Resources.getSystem().displayMetrics.widthPixels
    val params = this.layoutParams
    params.width = (deviceWidth - ((deviceWidth * percentageDecrease) / 100))
    this.layoutParams = params
}

fun View.setupElevationProperty(value: Float) {
    if (VersionUtils.isLollipop()) {
        this.elevation = value
    }
}

fun View.setupElevationProperty(@DimenRes id: Int) {
    val DEFAULT_ELEVATION = 8.0f
    if (VersionUtils.isLollipop()) {
        this.setupElevationProperty(this.context?.resources?.getDimension(id) ?: DEFAULT_ELEVATION)
    }
}



