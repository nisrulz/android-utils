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

package github.nisrulz.androidutils.ktx.activity

import android.app.Activity
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import github.nisrulz.androidutils.ktx.misc.VersionUtils


inline fun <reified T : Activity> Activity.startActivity() = startActivity(Intent(this, T::class.java))

inline fun <reified T : Activity> Activity.startActivity(requestCode: Int) = startActivityForResult(Intent(this, T::class.java), requestCode)

inline fun <reified T : Service> Activity.startService() = startService(Intent(this, T::class.java))

inline fun <reified T : Service> Activity.startService(sc: ServiceConnection, flags: Int = Context.BIND_AUTO_CREATE) = bindService(Intent(this, T::class.java), sc, flags)


fun Activity.hideActionBar() {
    // Call before calling setContentView();
    this.window?.requestFeature(Window.FEATURE_ACTION_BAR)
    this.actionBar?.hide()
}

fun Activity.setFullScreen() {
    // Call before calling setContentView();
    this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
}

fun Activity.getScreenSize(): IntArray {
    val size = Point()
    val w = this.windowManager

    w.defaultDisplay.getSize(size)
    return intArrayOf(size.x, size.y)
}

fun Activity.clearWindowBackground() = window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

fun Activity.steepStatusBar() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
    }
}

fun Activity.hideInputMethod() = window.peekDecorView()?.let {
    (this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
            .hideSoftInputFromWindow(window.peekDecorView().windowToken, 0)
}

fun Activity.showInputMethod(v: EditText) {
    v.requestFocus()
    (this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).showSoftInput(v, InputMethodManager.SHOW_FORCED)
}


// Hide On Screen Keyboard for EditText
fun Activity.hideOnScreenKeyboardForEditText(editText: EditText) {
    (this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
            .hideSoftInputFromWindow(editText.windowToken, 0)
}

fun Activity.setOrientation(status: Boolean) {
    if (status) {
        if (VersionUtils.isApiOrUp(Build.VERSION_CODES.JELLY_BEAN_MR2)) {
            this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LOCKED
        }
    } else {
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_USER
    }
}

fun Activity.toast(@StringRes resourceId: Int, length: Int = Toast.LENGTH_SHORT) = toast(getString(resourceId), length)

fun Activity.toast(message: String, length: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, message, length).show()

inline fun FragmentActivity.fragmentTransaction(function: FragmentTransaction.() -> FragmentTransaction) {
    supportFragmentManager.beginTransaction()
            .function()
            .commit()
}