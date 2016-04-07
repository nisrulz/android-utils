package github.nisrulz.scripts.misc;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The type Misc utils.
 *
 * @author Nishant Srivastava
 */
public class MiscUtils {

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
     * Write String data to a csv file
     *
     * @param sFileName the s file name
     * @param data      the data
     * @throws IOException   the io exception
     * @throws JSONException the json exception
     */
    public static void generateCsvFile(String sFileName, String data) throws IOException,
            JSONException {
        JSONObject objectToWrite = new JSONObject(data.toString());
        File folder = new File(Environment.getExternalStorageDirectory() + "/Folder");

        boolean var = false;
        if (!folder.exists())
            var = folder.mkdir();

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


        } catch (IOException e) {
            writer.flush();
            writer.close();
            e.printStackTrace();
        } catch (JSONException e) {
            writer.flush();
            writer.close();
            e.printStackTrace();
        } catch (Exception e) {
            writer.flush();
            writer.close();
            e.printStackTrace();
        }
    }
}
