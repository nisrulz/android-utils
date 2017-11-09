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

package github.nisrulz.androidutils.view;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.os.Build;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * The type View utils.
 *
 * @author Nishant Srivastava
 */
public class ViewUtil {

    /**
     * Get the screen dimensions
     *
     * @param activity the activity
     * @return the int [ ]
     */
    public static int[] getScreenSize(Activity activity) {
        Point size = new Point();
        WindowManager w = activity.getWindowManager();

        w.getDefaultDisplay().getSize(size);
        return new int[]{size.x, size.y};
    }

    /**
     * Hide On Screen Keyboard for EditText
     *
     * @param activity the activity
     * @param editText the edit text
     */
    public static void hideOnScreenKeyboardForEditText(Activity activity, EditText editText) {
        ((InputMethodManager) activity.getSystemService(
                Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    /**
     * Set orientation change lock
     *
     * @param activity the activity
     * @param status   the status
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

    private ViewUtil() {
        throw new UnsupportedOperationException(
                "Should not create instance of Util class. Please use as static..");
    }
}
