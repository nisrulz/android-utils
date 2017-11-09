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

    /**
     * Iterate over all keys of the JSON
     *
     * @param jsonObject the json object
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

    private JSONUtils() {
        throw new UnsupportedOperationException(
                "Should not create instance of Util class. Please use as static..");
    }

    /**
     * Read and parse a JSON file stored in assets folder
     *
     * @param context  the context
     * @param filename the filename
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
