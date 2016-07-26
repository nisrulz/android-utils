package github.nisrulz.scripts.view;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

/**
 * The type View utils.
 *
 * @author Nishant Srivastava
 */
public class ViewUtils {

  /**
   * Get screen size int [ ].
   *
   * @param activity the activity
   * @return the int [ ]
   */
  public static int[] getScreenSize(Activity activity) {
    Point size = new Point();
    WindowManager w = activity.getWindowManager();

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
      w.getDefaultDisplay().getSize(size);
      return new int[] { size.x, size.y };
    } else {
      Display d = w.getDefaultDisplay();
      //noinspection deprecation
      return new int[] { d.getWidth(), d.getHeight() };
    }
  }

  /**
   * Sets orientation.
   *
   * @param activity the activity
   * @param status the status
   */
  public static void setOrientation(Activity activity, boolean status) {
    if (status) {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
      }
    } else {
      activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER);
    }
  }
}
