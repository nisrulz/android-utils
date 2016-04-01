package github.nisrulz.scripts.network;

import android.content.Context;

import java.io.File;
import java.io.IOException;

import okhttp3.Response;
import okio.BufferedSink;
import okio.Okio;

/**
 * @author Nishant Srivastava
 */
public class OkHTTPUtils {

    public static void saveBinaryFileFromResponse(Context context, String filename, Response response) throws IOException {
        File downloadedFile = new File(context.getCacheDir(), filename);
        BufferedSink sink = Okio.buffer(Okio.sink(downloadedFile));
        sink.writeAll(response.body().source());
        sink.close();
    }
}
