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

package github.nisrulz.androidutils.misc;

import static android.view.WindowManager.LayoutParams;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.StrictMode;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * The type Misc utils.
 *
 * @author Nishant Srivastava
 */
public class MiscUtils {

    /**
     * Check if permission granted boolean.
     *
     * @param context    the context
     * @param permission the permission
     * @return the boolean
     */
    public static boolean checkIfPermissionGranted(Context context, String permission) {
        return (context.checkCallingOrSelfPermission(permission) == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Disable screenshot functionality.
     *
     * @param activity the activity
     */
    public static void disableScreenshotFunctionality(Activity activity) {
        activity.getWindow().setFlags(LayoutParams.FLAG_SECURE, LayoutParams.FLAG_SECURE);
    }

    /**
     * Enable strict mode.
     *
     * @param enable the enable flag
     */
    public static void enableStrictMode(boolean enable) {
        if (enable) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()   // or .detectAll() for all detectable problems
                    .penaltyLog()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    .penaltyDeath()
                    .build());
        }
    }

    /**
     * Write String data to a csv file
     *
     * @param sFileName the s file name
     * @param data      the data
     * @throws IOException   the io exception
     * @throws JSONException the json exception
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
     * Gets random number in range.
     *
     * @param min the min
     * @param max the max
     * @return the random number in range
     */
    public static int getRandomNumberInRange(int min, int max) {
        return (min + (int) (Math.random() * ((max - min) + 1)));
    }



    private MiscUtils() {
        throw new UnsupportedOperationException(
                "Should not create instance of Util class. Please use as static..");
    }
}
