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

package github.nisrulz.androidutils.wakelock;

import android.content.Context;
import android.os.PowerManager;

/**
 * The type Wake lock utils.
 *
 * @author Nishant Srivastava
 */
public class WakeLockUtils {

    /**
     * The Wake lock.
     */
    private static PowerManager.WakeLock wakeLock;

    public static void holdWakeLock(Context context) {
        holdWakeLockTimed(context, 3600);
    }

    /**
     * Hold wake lock.
     *
     * @param context the context
     */
    public static void holdWakeLockTimed(Context context, long time) {
        PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "MyWakeLock");
        wakeLock.acquire(time);
    }

    /**
     * Release wake lock.
     */
    public static void releaseWakeLock() {
        if (wakeLock != null && wakeLock.isHeld()) {
            wakeLock.release();
        }
    }

    private WakeLockUtils() {
        throw new UnsupportedOperationException(
                "Should not create instance of Util class. Please use as static..");
    }
}
