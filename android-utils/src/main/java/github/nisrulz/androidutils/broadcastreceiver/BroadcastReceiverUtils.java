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

package github.nisrulz.androidutils.broadcastreceiver;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

/**
 * The type Broadcast receiver utils.
 *
 * @author Nishant Srivastava
 */
public class BroadcastReceiverUtils {

    /**
     * Broadcast data as a message
     *
     * @param context          the context
     * @param data             the data
     * @param action           the action
     * @param custompermission the custompermission
     */
    public static void broadcastData(Context context, String data, String action,
            String custompermission) {
        Intent i = new Intent();
        i.putExtra("data", data);
        i.setAction(action); // action ~ "com.example.android.action"
        context.sendBroadcast(i,
                custompermission); // custompermisson ~ "com.example.permission.MY_PERMISSION"
    }

    /**
     * Enable/Disable Broadcast Receiver
     *
     * @param context the context
     * @param brClass the br class
     * @param enabled the enabled
     */
    public static void setStateOfReceiver(Context context, Class<?> brClass, boolean enabled) {
        ComponentName receiverName = new ComponentName(context, brClass.getName());
        PackageManager pm = context.getPackageManager();

        int newstate;
        if (enabled) {
            newstate = PackageManager.COMPONENT_ENABLED_STATE_ENABLED;
        } else {
            newstate = PackageManager.COMPONENT_ENABLED_STATE_DISABLED;
        }

        pm.setComponentEnabledSetting(receiverName, newstate, PackageManager.DONT_KILL_APP);
    }

    private BroadcastReceiverUtils() {
        throw new UnsupportedOperationException(
                "Should not create instance of Util class. Please use as static..");
    }
}
