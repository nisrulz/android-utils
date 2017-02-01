package github.nisrulz.androidutils.network;

import github.nisrulz.androidutils.BuildConfig;
import github.nisrulz.androidutils.misc.MiscUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class HTTPResponseUtilTest {

  HTTPResponseUtil httpResponseUtil;
  HTTPResponseInfo httpResponseInfo;


  @Before
  public void setUp() throws Exception {
    httpResponseUtil = new HTTPResponseUtil();
  }

  @After
  public void tearDown() throws Exception {
    httpResponseUtil = null;
  }

  @Test
  public void getInfoWhenStatusCodeIs200() throws Exception {
    httpResponseInfo= httpResponseUtil.getInfo(200);

    assertEquals(httpResponseInfo.getStatusCode(), 200);
    assertEquals(httpResponseInfo.getStatusText(), "Ok");
    assertEquals(httpResponseInfo.getStatusDescription(), "The request has succeeded. The meaning of a success varies depending on the HTTP method:\n"
        + "GET: The resource has been fetched and is transmitted in the message body.\n"
        + "HEAD: The entity headers are in the message body.\n"
        + "POST: The resource describing the result of the action is transmitted in the message body.\n"
        + "TRACE: The message body contains the request message as received by the server");

    assertEquals(httpResponseInfo.getType(), "Successful Response");

  }

  @Test
  public void getInfoWhenStatusCodeIsRandom() throws Exception {
    int randomStatusCode = MiscUtils.getRandomNumberInRange(101,199);
    httpResponseInfo= httpResponseUtil.getInfo(randomStatusCode);

    assertNotEquals(httpResponseInfo.getStatusCode(), 200);
    assertNotEquals(httpResponseInfo.getStatusText(), "Ok");
    assertNotEquals(httpResponseInfo.getStatusDescription(), "The request has succeeded. The meaning of a success varies depending on the HTTP method:\n"
        + "GET: The resource has been fetched and is transmitted in the message body.\n"
        + "HEAD: The entity headers are in the message body.\n"
        + "POST: The resource describing the result of the action is transmitted in the message body.\n"
        + "TRACE: The message body contains the request message as received by the server");

    assertNotEquals(httpResponseInfo.getType(), "Successful Response");

  }
}