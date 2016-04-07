package github.nisrulz.scripts.wakelock;

import android.content.Context;
import android.os.PowerManager;

/**
 * @author Nishant Srivastava
 */
public class WakeLockUtils {
    static PowerManager.WakeLock wakeLock;

    public static void holdWakeLock(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "MyWakeLock");
        wakeLock.acquire();
    }

    public static void releaseWakeLock() {
        if (wakeLock != null && wakeLock.isHeld()) {
            wakeLock.release();
        }
    }
}
