package github.nisrulz.androidutils.network;

import github.nisrulz.androidutils.misc.MiscUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

    Assert.assertEquals(httpResponseInfo.getStatusCode(), 200);
    Assert.assertEquals(httpResponseInfo.getStatusText(), "Ok");
    Assert.assertEquals(httpResponseInfo.getStatusDescription(), "The request has succeeded. The meaning of a success varies depending on the HTTP method:\n"
        + "GET: The resource has been fetched and is transmitted in the message body.\n"
        + "HEAD: The entity headers are in the message body.\n"
        + "POST: The resource describing the result of the action is transmitted in the message body.\n"
        + "TRACE: The message body contains the request message as received by the server");

    Assert.assertEquals(httpResponseInfo.getType(), "Successful Response");

  }

  @Test
  public void getInfoWhenStatusCodeIsRandom() throws Exception {
    int randomStatusCode = MiscUtils.getRandomNumberInRange(101,199);
    httpResponseInfo= httpResponseUtil.getInfo(randomStatusCode);

    Assert.assertNotEquals(httpResponseInfo.getStatusCode(), 200);
    Assert.assertNotEquals(httpResponseInfo.getStatusText(), "Ok");
    Assert.assertNotEquals(httpResponseInfo.getStatusDescription(), "The request has succeeded. The meaning of a success varies depending on the HTTP method:\n"
        + "GET: The resource has been fetched and is transmitted in the message body.\n"
        + "HEAD: The entity headers are in the message body.\n"
        + "POST: The resource describing the result of the action is transmitted in the message body.\n"
        + "TRACE: The message body contains the request message as received by the server");

    Assert.assertNotEquals(httpResponseInfo.getType(), "Successful Response");

  }
}