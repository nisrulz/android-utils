package github.nisrulz.androidutils.sharedpreferences;

import android.content.Context;

/**
 * The type Shared pref utils.
 *
 * @author Nishant Srivastava
 */
public class SharedPrefUtils {

  private static final String PREF_APP = "pref_app";

  private SharedPrefUtils() {
    throw new UnsupportedOperationException(
        "Should not create instance of Util class. Please use as static..");
  }

  /**
   * Save data.
   *
   * @param context
   *     the context
   * @param key
   *     the key
   * @param val
   *     the val
   */
  // Save Data
  static public void saveData(Context context, String key, String val) {
    context.getSharedPreferences(PREF_APP, Context.MODE_PRIVATE).edit().putString(key, val).apply();
  }

  /**
   * Save data.
   *
   * @param context
   *     the context
   * @param key
   *     the key
   * @param val
   *     the val
   */
  static public void saveData(Context context, String key, int val) {
    context.getSharedPreferences(PREF_APP, Context.MODE_PRIVATE).edit().putInt(key, val).apply();
  }

  /**
   * Save data.
   *
   * @param context
   *     the context
   * @param key
   *     the key
   * @param val
   *     the val
   */
  static public void saveData(Context context, String key, boolean val) {
    context.getSharedPreferences(PREF_APP, Context.MODE_PRIVATE)
        .edit()
        .putBoolean(key, val)
        .apply();
  }

  /**
   * Gets string data.
   *
   * @param context
   *     the context
   * @param key
   *     the key
   * @return the string data
   */
  // Get Data
  static public String getStringData(Context context, String key) {
    return context.getSharedPreferences(PREF_APP, Context.MODE_PRIVATE).getString(key, null);
  }

  /**
   * Gets int data.
   *
   * @param context
   *     the context
   * @param key
   *     the key
   * @return the int data
   */
  static public int getIntData(Context context, String key) {
    return context.getSharedPreferences(PREF_APP, Context.MODE_PRIVATE).getInt(key, 0);
  }

  /**
   * Gets boolean data.
   *
   * @param context
   *     the context
   * @param key
   *     the key
   * @return the boolean data
   */
  static public boolean getBooleanData(Context context, String key) {

    return context.getSharedPreferences(PREF_APP, Context.MODE_PRIVATE).getBoolean(key, false);
  }
}
