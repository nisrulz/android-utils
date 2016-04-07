package github.nisrulz.scripts.network;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * The type Network utils.
 *
 * @author Nishant Srivastava
 */
public class NetworkUtils {
    /**
     * Check if there is Internet Connection Available or not
     *
     * @param context the context
     * @return the boolean
     */
    static boolean isNetworkAvailable(Context context) {
        if (context.checkCallingOrSelfPermission(Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED) {

            ConnectivityManager cm = (ConnectivityManager) context
                    .getApplicationContext().getSystemService(
                            Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnected()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}
