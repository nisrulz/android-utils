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

import static org.junit.Assert.*;

import github.nisrulz.androidutils.BuildConfig;
import github.nisrulz.androidutils.misc.MiscUtils;
import org.junit.*;
import org.junit.runner.*;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class HTTPResponseUtilTest {

    HTTPResponseInfo httpResponseInfo;

    HTTPResponseUtil httpResponseUtil;

    @Test
    public void getInfoWhenStatusCodeIs200() throws Exception {
        httpResponseInfo = httpResponseUtil.getInfo(200);

        assertEquals(httpResponseInfo.getStatusCode(), 200);
        assertEquals(httpResponseInfo.getStatusText(), "Ok");
        assertEquals(httpResponseInfo.getStatusDescription(),
                "The request has succeeded. The meaning of a success varies depending on the HTTP method:\n"
                        + "GET: The resource has been fetched and is transmitted in the message body.\n"
                        + "HEAD: The entity headers are in the message body.\n"
                        + "POST: The resource describing the result of the action is transmitted in the message body.\n"
                        + "TRACE: The message body contains the request message as received by the server");

        assertEquals(httpResponseInfo.getType(), "Successful Response");
    }

    @Test
    public void getInfoWhenStatusCodeIsRandom() throws Exception {
        int randomStatusCode = MiscUtils.getRandomNumberInRange(101, 199);
        httpResponseInfo = httpResponseUtil.getInfo(randomStatusCode);

        assertNotEquals(httpResponseInfo.getStatusCode(), 200);
        assertNotEquals(httpResponseInfo.getStatusText(), "Ok");
        assertNotEquals(httpResponseInfo.getStatusDescription(),
                "The request has succeeded. The meaning of a success varies depending on the HTTP method:\n"
                        + "GET: The resource has been fetched and is transmitted in the message body.\n"
                        + "HEAD: The entity headers are in the message body.\n"
                        + "POST: The resource describing the result of the action is transmitted in the message body.\n"
                        + "TRACE: The message body contains the request message as received by the server");

        assertNotEquals(httpResponseInfo.getType(), "Successful Response");
    }

    @Before
    public void setUp() throws Exception {
        httpResponseUtil = new HTTPResponseUtil();
    }

    @After
    public void tearDown() throws Exception {
        httpResponseUtil = null;
    }
}