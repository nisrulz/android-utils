package github.nisrulz.scripts.activity;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

/**
 * The type Activity utils.
 */
public class ActivityUtils {
    /**
     * Sets full screen.
     *
     * @param activity the activity
     */
    public  static void setFullScreen(Activity activity) {
        // Call before calling setContentView();
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager
                .LayoutParams
                .FLAG_FULLSCREEN);
    }

    /**
     * Hide action bar.
     *
     * @param activity the activity
     */
    public static void hideActionBar(Activity activity) {
        // Call before calling setContentView();
        activity.getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            activity.getActionBar().hide();
        }
    }
}