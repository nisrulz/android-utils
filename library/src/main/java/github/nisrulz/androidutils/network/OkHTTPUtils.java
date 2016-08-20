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

  private OkHTTPUtils() {
    throw new UnsupportedOperationException(
        "Should not create instance of Util class. Please use as static..");
  }

  /**
   * Save the response as a binary file i.e html file.
   *
   * @param context
   *     the context
   * @param filename
   *     the filename
   * @param response
   *     the response
   * @throws IOException
   *     the io exception
   */
  public static void saveBinaryFileFromResponse(Context context, String filename, Response response)
      throws IOException {
    File downloadedFile = new File(context.getCacheDir(), filename);
    BufferedSink sink = Okio.buffer(Okio.sink(downloadedFile));
    sink.writeAll(response.body().source());
    sink.close();
  }
}
