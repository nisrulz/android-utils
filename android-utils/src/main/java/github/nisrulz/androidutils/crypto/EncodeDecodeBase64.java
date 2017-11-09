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

package github.nisrulz.androidutils.crypto;

import android.util.Base64;
import java.util.Arrays;

/**
 * The type Encode decode base 64.
 */
public class EncodeDecodeBase64 {

    /**
     * Decode encoded message using Base64
     *
     * @param message the message
     * @return the string
     */
    public static String decodedMessage(String message) {
        return Arrays.toString(Base64.decode(message, Base64.DEFAULT));
    }

    /**
     * Encode message using Base64 encoding
     *
     * @param message the message
     * @return the string
     */
    public static String encodedMessage(String message) {
        return Base64.encodeToString(message.getBytes(), Base64.DEFAULT);
    }

    private EncodeDecodeBase64() {
        throw new UnsupportedOperationException(
                "Should not create instance of Util class. Please use as static..");
    }
}
