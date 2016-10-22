package github.nisrulz.androidutils.json;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * The type Json utils.
 *
 * @author Nishant Srivastava
 */
public class JSONUtils {

  private JSONUtils() {
    throw new UnsupportedOperationException(
        "Should not create instance of Util class. Please use as static..");
  }

  /**
   * Iterate over all keys of the JSON
   *
   * @param jsonObject
   *     the json object
   * @return the hash map
   */
  public static HashMap<String, String> iterateOverJSON(JSONObject jsonObject) {
    Iterator<String> iter = jsonObject.keys();
    HashMap<String, String> keyValueMap = new HashMap<>();
    while (iter.hasNext()) {
      String key = iter.next();
      try {
        String value = jsonObject.getString(key);
        keyValueMap.put(key, value);
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }
    return keyValueMap;
  }

  /**
   * Read and parse a JSON file stored in assets folder
   *
   * @param context
   *     the context
   * @param filename
   *     the filename
   * @return the json object
   */
  public JSONObject loadJSONFromAsset(Context context, String filename) {
    String json = null;
    JSONObject jsonObject = null;
    try {

      InputStream is = context.getAssets().open(filename);

      int size = is.available();

      byte[] buffer = new byte[size];

      final int read = is.read(buffer);
      is.close();
      if (read > 0) {
        json = new String(buffer, "UTF-8");
      }
    } catch (IOException ex) {
      ex.printStackTrace();
      return null;
    }

    try {
      jsonObject = new JSONObject(json);
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return jsonObject;
  }
}
