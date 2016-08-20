package github.nisrulz.androidutils.service;

import android.app.ActivityManager;
import android.content.Context;

/**
 * The type Service utils.
 *
 * @author Nishant Srivastava
 */
public class ServiceUtils {

  private ServiceUtils() {
    throw new UnsupportedOperationException(
        "Should not create instance of Util class. Please use as static..");
  }

  /**
   * Check if the service is running in the device.
   *
   * @param context
   *     the context
   * @param serviceClass
   *     the service class
   * @return boolean boolean
   */
  public static boolean isServiceRunning(Context context, Class<?> serviceClass) {
    try {
      ActivityManager manager =
          (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
      for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(
          Integer.MAX_VALUE)) {
        if (serviceClass.getName().equals(service.service.getClassName())) {
          return true;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }
}
