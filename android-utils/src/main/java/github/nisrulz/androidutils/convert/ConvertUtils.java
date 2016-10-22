package github.nisrulz.androidutils.convert;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.DisplayMetrics;
import java.util.HashMap;
import java.util.List;

/**
 * The type Convert utils.
 *
 * @author Nishant Srivastava
 */
public class ConvertUtils {

  private ConvertUtils() {
    throw new UnsupportedOperationException(
        "Should not create instance of Util class. Please use as static..");
  }

  /**
   * short array to byte array.
   *
   * @param sData
   *     the s data
   * @return the byte []
   */
  public static byte[] short2byte(short[] sData) {
    int shortArrsize = sData.length;
    byte[] bytes = new byte[shortArrsize * 2];
    for (int i = 0; i < shortArrsize; i++) {
      bytes[i * 2] = (byte) (sData[i] & 0x00FF);
      bytes[(i * 2) + 1] = (byte) (sData[i] >> 8);
      sData[i] = 0;
    }
    return bytes;
  }

  /***
   * Android L (lollipop, API 21) introduced a new problem when trying to invoke implicit intent,
   * "java.lang.IllegalArgumentException: Service Intent must be explicit"
   * <p/>
   * If you are using an implicit intent, and know only 1 target would answer this intent,
   * This method will help you turn the implicit intent into the explicit form.
   * <p/>
   * Inspired from SO answer: http://stackoverflow.com/a/26318757/1446466
   *
   * @param context
   *     the context
   * @param implicitIntent
   *     - The original implicit intent
   * @return Explicit Intent created from the implicit original intent
   */
  public static Intent implicit2ExplicitIntent(Context context, Intent implicitIntent) {
    // Retrieve all services that can match the given intent
    PackageManager pm = context.getPackageManager();
    List<ResolveInfo> resolveInfo = pm.queryIntentServices(implicitIntent, 0);

    // Make sure only one match was found
    if (resolveInfo == null || resolveInfo.size() != 1) {
      return null;
    }

    // Get component info and create ComponentName
    ResolveInfo serviceInfo = resolveInfo.get(0);
    String packageName = serviceInfo.serviceInfo.packageName;
    String className = serviceInfo.serviceInfo.name;
    ComponentName component = new ComponentName(packageName, className);

    // Create a new intent. Use the old one for extras and such reuse
    Intent explicitIntent = new Intent(implicitIntent);

    // Set the component to be explicit
    explicitIntent.setComponent(component);

    return explicitIntent;
  }

  /**
   * Dp to pixels
   *
   * @param context
   *     the context
   * @param dp
   *     the dp
   * @return the int
   */
  public static int dpToPixels(Activity context, int dp) {
    DisplayMetrics metrics = new DisplayMetrics();
    context.getWindowManager().getDefaultDisplay().getMetrics(metrics);
    return (int) ((dp * metrics.density) + 0.5);
  }

  /**
   * Pixels to dp int.
   *
   * @param context
   *     the context
   * @param px
   *     the px
   * @return the int
   */
  public static int pixelsToDp(Activity context, int px) {
    DisplayMetrics metrics = new DisplayMetrics();
    context.getWindowManager().getDefaultDisplay().getMetrics(metrics);
    return (int) ((px / metrics.density) + 0.5);
  }

  /**
   * Sp to px
   *
   * @param context
   *     the context
   * @param sp
   *     the sp
   * @return the int
   */
  public static int spToPx(Context context, float sp) {
    final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
    return (int) (sp * fontScale + 0.5f);
  }

  /**
   * Px to sp
   *
   * @param context
   *     the context
   * @param px
   *     the px
   * @return the int
   */
  public static int pxToSp(Context context, float px) {
    final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
    return (int) (px / fontScale + 0.5f);
  }

  /**
   * Convert HashMap<String,String> to key=value type String
   *
   * @param params
   *     the params
   * @return the string
   */
  public static String hashMap2String(HashMap<String, String> params) {
    StringBuilder st = new StringBuilder();
    for (String key : params.keySet()) {
      st.append(key).append("=").append(params.get(key)).append("&");
    }
    st.deleteCharAt(st.lastIndexOf("&"));
    return st.toString();
  }

  /**
   * Convert key=value type String to HashMap<String,String>
   *
   * @param paramString
   *     the param string
   * @return hash map
   */
  public static HashMap<String, String> string2HashMap(String paramString) {
    HashMap<String, String> params = new HashMap<>();
    // Split String on basis of separator used, here '&'
    for (String keyValue : paramString.split(" *& *")) {

      // Here the each part is futher splitted taking in account the equal
      // sign '=' which demarcates the key
      // and valuefor the hashmap
      String[] pairs = keyValue.split(" *= *", 2);

      // Those key and values are then put into hashmap
      params.put(pairs[0], pairs.length == 1 ? "" : pairs[1]);
    }
    return params;
  }
}
