package github.nisrulz.androidutils.misc;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.widget.Toast;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

import static android.view.WindowManager.LayoutParams;

/**
 * The type Misc utils.
 *
 * @author Nishant Srivastava
 */
public class MiscUtils {

  private MiscUtils() {
    throw new UnsupportedOperationException(
        "Should not create instance of Util class. Please use as static..");
  }

  /**
   * Gets random number in range.
   *
   * @param min
   *     the min
   * @param max
   *     the max
   * @return the random number in range
   */
  public static int getRandomNumberInRange(int min, int max) {
    return (min + (int) (Math.random() * ((max - min) + 1)));
  }

  /**
   * Check if permission granted boolean.
   *
   * @param context
   *     the context
   * @param permission
   *     the permission
   * @return the boolean
   */
  public static boolean checkIfPermissionGranted(Context context, String permission) {
    return (context.checkCallingOrSelfPermission(permission) == PackageManager.PERMISSION_GRANTED);
  }

  /**
   * Write String data to a csv file
   *
   * @param sFileName
   *     the s file name
   * @param data
   *     the data
   * @throws IOException
   *     the io exception
   * @throws JSONException
   *     the json exception
   */
  public static void generateCsvFile(String sFileName, String data)
      throws IOException, JSONException {
    JSONObject objectToWrite = new JSONObject(data);
    File folder = new File(Environment.getExternalStorageDirectory() + "/Folder");

    boolean var = false;
    if (!folder.exists()) {
      var = folder.mkdir();
    }

    System.out.println("" + var);

    final String filename = folder.toString() + "/" + sFileName;

    FileWriter writer = new FileWriter(filename, true);

    try {

      writer.append(objectToWrite.get("x").toString());
      writer.append(',');
      writer.append(objectToWrite.get("y").toString());
      writer.append(',');
      writer.append(objectToWrite.get("z").toString());
      writer.append('\n');
      writer.flush();
      writer.close();
    } catch (Exception e) {
      writer.flush();
      writer.close();
      e.printStackTrace();
    }
  }

  /**
   * Rate my app.
   *
   * @param context
   *     the context
   */
  public static void rateMyApp(Context context) {

    Uri uri = Uri.parse("market://details?id=" + context.getPackageName());
    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
    // To count with Play market backstack, After pressing back button,
    // to taken back to our application, we need to add following flags to intent.
    goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
        Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET |
        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
    try {
      context.startActivity(goToMarket);
    } catch (ActivityNotFoundException e) {
      Intent i = new Intent(Intent.ACTION_VIEW,
          Uri.parse("http://play.google.com/store/apps/details?id=" + context.getPackageName()));
      if (i.resolveActivity(context.getPackageManager()) != null) {
        context.startActivity(i);
      }
      else {
        Toast.makeText(context, "Playstore Unavailable", Toast.LENGTH_SHORT).show();
      }
    }
  }

  /**
   * Share my app.
   *
   * @param context
   *     the context
   * @param subject
   *     the subject
   * @param message
   *     the message
   */
  public static void shareMyApp(Context context, String subject, String message) {
    try {
      String appUrl = "https://play.google.com/store/apps/details?id=" + context.getPackageName();
      Intent i = new Intent(Intent.ACTION_SEND);
      i.setType("text/plain");
      i.putExtra(Intent.EXTRA_SUBJECT, subject);
      String leadingText = "\n" + message + "\n\n";
      leadingText += appUrl + "\n\n";
      i.putExtra(Intent.EXTRA_TEXT, leadingText);
      context.startActivity(Intent.createChooser(i, "Share using"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Send mail.
   *
   * @param context
   *     the context
   * @param mailtoid
   *     the mailtoid
   * @param subject
   *     the subject
   * @param body
   *     the body
   */
  public static void sendMail(Context context, String mailtoid, String subject, String body) {
    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", mailtoid, null));
    emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
    emailIntent.putExtra(Intent.EXTRA_TEXT, body);
    context.startActivity(Intent.createChooser(emailIntent, "Send email"));
  }

  /**
   * Enable strict mode.
   *
   * @param enable
   *     the enable flag
   */
  public static void enableStrictMode(boolean enable) {
    if (enable) {
      StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads()
          .detectDiskWrites()
          .detectNetwork()   // or .detectAll() for all detectable problems
          .penaltyLog()
          .build());
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects()
            .detectLeakedClosableObjects()
            .penaltyLog()
            .penaltyDeath()
            .build());
      }
    }
  }

  /**
   * Disable screenshot functionality.
   *
   * @param activity
   *     the activity
   */
  public static void disableScreenshotFunctionality(Activity activity) {
    activity.getWindow().setFlags(LayoutParams.FLAG_SECURE, LayoutParams.FLAG_SECURE);
  }
}
