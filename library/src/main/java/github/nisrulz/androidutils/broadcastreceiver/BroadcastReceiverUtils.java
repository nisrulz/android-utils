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

  private BroadcastReceiverUtils() {
    throw new UnsupportedOperationException(
        "Should not create instance of Util class. Please use as static..");
  }

  /**
   * Enable/Disable Broadcast Receiver
   *
   * @param context
   *     the context
   * @param brClass
   *     the br class
   * @param enabled
   *     the enabled
   */
  public static void setStateOfReceiver(Context context, Class<?> brClass, boolean enabled) {
    ComponentName receiverName = new ComponentName(context, brClass.getName());
    PackageManager pm = context.getPackageManager();

    int newstate;
    if (enabled) {
      newstate = PackageManager.COMPONENT_ENABLED_STATE_ENABLED;
    }
    else {
      newstate = PackageManager.COMPONENT_ENABLED_STATE_DISABLED;
    }

    pm.setComponentEnabledSetting(receiverName, newstate, PackageManager.DONT_KILL_APP);
  }

  /**
   * Broadcast data as a message
   *
   * @param context
   *     the context
   * @param data
   *     the data
   * @param action
   *     the action
   * @param custompermission
   *     the custompermission
   */
  public static void broadcastData(Context context, String data, String action,
      String custompermission) {
    Intent i = new Intent();
    i.putExtra("data", data);
    i.setAction(action); // action ~ "com.example.android.action"
    context.sendBroadcast(i,
        custompermission); // custompermisson ~ "com.example.permission.MY_PERMISSION"
  }
}
