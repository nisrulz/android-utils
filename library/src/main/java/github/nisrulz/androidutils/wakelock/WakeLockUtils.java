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

  private WakeLockUtils() {
    throw new UnsupportedOperationException(
        "Should not create instance of Util class. Please use as static..");
  }

  /**
   * Hold wake lock.
   *
   * @param context
   *     the context
   */
  public static void holdWakeLock(Context context) {
    PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
    wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "MyWakeLock");
    wakeLock.acquire();
  }

  /**
   * Release wake lock.
   */
  public static void releaseWakeLock() {
    if (wakeLock != null && wakeLock.isHeld()) {
      wakeLock.release();
    }
  }
}
