package github.nisrulz.androidutils.debug;

import android.app.Activity;
import android.os.Debug;
import android.util.Log;
import android.view.WindowManager;

/**
 * The type Debug utils.
 */
public class DebugUtils {

  private DebugUtils() {
    throw new UnsupportedOperationException(
        "Should not create instance of Util class. Please use as static..");
  }

  /**
   * Keep screen on while debugging.
   *
   * @param activity
   *     the activity
   * @param debugging
   *     the debugging
   */
  public static void keepScreenOnWhileDebugging(Activity activity, boolean debugging) {
    if (debugging) { // don't even consider it otherwise
      if (Debug.isDebuggerConnected()) {
        Log.d("SCREEN",
            "Keeping screen on for debugging, detach debugger and force an onResume to turn it off.");
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
      }
      else {
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        Log.d("SCREEN", "Keeping screen on for debugging is now deactivated.");
      }
    }
  }
}