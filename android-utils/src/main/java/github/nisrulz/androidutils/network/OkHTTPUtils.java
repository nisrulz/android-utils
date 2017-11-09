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

package github.nisrulz.androidutils.network;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import okhttp3.Response;
import okio.BufferedSink;
import okio.Okio;

/**
 * The type Ok http utils.
 *
 * @author Nishant Srivastava
 */
public class OkHTTPUtils {

    /**
     * Save the response as a binary file i.e html file.
     *
     * @param context  the context
     * @param filename the filename
     * @param response the response
     * @throws IOException the io exception
     */
    public static void saveBinaryFileFromResponse(Context context, String filename, Response response)
            throws IOException {
        File downloadedFile = new File(context.getCacheDir(), filename);
        BufferedSink sink = Okio.buffer(Okio.sink(downloadedFile));
        sink.writeAll(response.body().source());
        sink.close();
    }

    private OkHTTPUtils() {
        throw new UnsupportedOperationException(
                "Should not create instance of Util class. Please use as static..");
    }
}
