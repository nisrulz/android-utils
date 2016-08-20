package github.nisrulz.androidutils.battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

/**
 * The type Battery utils.
 *
 * @author Nishant Srivastava
 */
public class BatteryUtils {

  private BatteryUtils() {
    throw new UnsupportedOperationException(
        "Should not create instance of Util class. Please use as static..");
  }

  /**
   * Register a listener for getting updates of device charging, discharging or completely charged.
   *
   * @param context
   *     the context
   * @param batteryChargeListener
   *     the battery charge listener
   */
  public static void registerBatteryChangeBroadcastReceiver(Context context,
      final BatteryChargeListener batteryChargeListener) {
    final IntentFilter theFilter = new IntentFilter();
    /** System Defined Broadcast */
    theFilter.addAction(Intent.ACTION_BATTERY_CHANGED);

    BroadcastReceiver batteryChargeReceiver = new BroadcastReceiver() {
      @Override
      public void onReceive(Context context, Intent intent) {
        int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, 0);

        if (status == BatteryManager.BATTERY_STATUS_CHARGING) {
          // Is Charging
          batteryChargeListener.isCharging();
        }
        if (status == BatteryManager.BATTERY_STATUS_FULL) {
          // Is Full
          batteryChargeListener.isFull();
        }
        else {
          // Is Discharging
          batteryChargeListener.isDiscahrging();
        }
      }
    };
    context.getApplicationContext().registerReceiver(batteryChargeReceiver, theFilter);
  }

  /**
   * The interface Battery charge listener.
   */
  public interface BatteryChargeListener {
    /**
     * Is charging.
     */
    void isCharging();

    /**
     * Is full.
     */
    void isFull();

    /**
     * Is discahrging.
     */
    void isDiscahrging();
  }
}
