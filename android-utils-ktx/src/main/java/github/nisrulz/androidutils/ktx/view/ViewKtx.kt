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
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Build
import android.support.annotation.*
import android.support.annotation.IntRange
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
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

inline fun ViewGroup.inflate(@LayoutRes l: Int): View =
        LayoutInflater.from(context).inflate(l, this, false)

// Get the children at index
inline operator fun ViewGroup.get(i: Int): View? = getChildAt(i)

//  -=
inline operator fun ViewGroup.minusAssign(child: View) = removeView(child)

// +=
inline operator fun ViewGroup.plusAssign(child: View) = addView(child)

// if (view in views)
inline fun ViewGroup.contains(child: View) = indexOfChild(child) != -1

inline fun ViewGroup.first(): View? = this[0]

inline fun ViewGroup.forEach(action: (View) -> Unit) {
    for (i in 0 until childCount) {
        action(getChildAt(i))
    }
}


inline fun ViewGroup.forEachIndexed(action: (Int, View) -> Unit) {
    for (i in 0 until childCount) {
        action(i, getChildAt(i))
    }
}

// for (view in views.children())
inline fun ViewGroup.children() = object : Iterable<View> {
    override fun iterator() = object : Iterator<View> {
        var index = 0
        override fun hasNext() = index < childCount
        override fun next() = getChildAt(index++)
    }
}

@RequiresApi(Build.VERSION_CODES.HONEYCOMB)
@UiThread
inline fun View.fadeOut() {
    fadeOut(500)
}

@RequiresApi(Build.VERSION_CODES.HONEYCOMB)
@UiThread
inline fun View.fadeIn() {
    fadeIn(500)
}

@RequiresApi(Build.VERSION_CODES.HONEYCOMB)
@UiThread
inline fun View.fadeIn(durationInMs: Long) {
    this.clearAnimation()
    val anim = AlphaAnimation(this.alpha, 1.0f)
    anim.duration = durationInMs
    this.startAnimation(anim)
}

@RequiresApi(Build.VERSION_CODES.HONEYCOMB)
@UiThread
inline fun View.fadeOut(durationInMs: Long) {
    this.clearAnimation()
    val anim = AlphaAnimation(this.alpha, 0.0f)
    anim.duration = durationInMs
    this.startAnimation(anim)
}


fun View.getBitmap(): Bitmap {
    val bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bmp)
    draw(canvas)
    canvas.save()
    return bmp
}


fun View.isVisible() = visibility == View.VISIBLE

fun View.isGone() = visibility == View.GONE

fun View.isInvisible() = visibility == View.INVISIBLE

fun View.gone() {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
}

inline fun View.goneIf(block: () -> Boolean) {
    if (visibility != View.GONE && block()) {
        visibility = View.GONE
    }
}

fun View.visible() {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
}

inline fun View.visibleIf(block: () -> Boolean) {
    if (visibility != View.VISIBLE && block()) {
        visibility = View.VISIBLE
    }
}

fun View.invisible() {
    if (visibility != View.INVISIBLE) {
        visibility = View.INVISIBLE
    }
}

inline fun View.invisibleIf(block: () -> Boolean) {
    if (visibility != View.INVISIBLE && block()) {
        visibility = View.INVISIBLE
    }
}

fun View.setHeight(value: Int) {
    val lp = layoutParams
    lp?.let {
        lp.height = value
        layoutParams = lp
    }
}

fun View.setWidth(value: Int) {
    val lp = layoutParams
    lp?.let {
        lp.width = value
        layoutParams = lp
    }
}