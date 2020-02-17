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

package github.nisrulz.androidutils.ktx.fragment

import android.app.Activity
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import github.nisrulz.androidutils.ktx.activity.toast


inline fun <reified T : Activity> Fragment.openActivity() = startActivity(Intent(activity, T::class.java))

inline fun <reified T : Activity> Fragment.openActivity(requestCode: Int) = startActivityForResult(Intent(activity, T::class.java), requestCode)

inline fun <reified T : Service> Fragment.openService() = activity?.startService(Intent(activity, T::class.java))

inline fun <reified T : Service> Fragment.openService(sc: ServiceConnection, flags: Int = Context.BIND_AUTO_CREATE) = activity?.bindService(Intent(activity, T::class.java), sc, flags)


fun Fragment.toast(resourceId: Int, length: Int = Toast.LENGTH_SHORT) {
    activity?.toast(resourceId, length)
}

fun Fragment.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    activity?.toast(message, length)
}

inline fun Fragment.fragmentTransaction(function: FragmentTransaction.() -> FragmentTransaction) {
    fragmentManager?.beginTransaction()
            ?.function()
            ?.commit()
}