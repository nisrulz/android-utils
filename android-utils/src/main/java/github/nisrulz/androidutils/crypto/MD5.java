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

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * The type Md 5.
 */
public class MD5 {

    /**
     * Get MD5 value for a string
     *
     * @param input the input
     * @return the string
     */
    public static String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            StringBuilder md5 = new StringBuilder(number.toString(16));

            while (md5.length() < 32) {
                md5.insert(0, "0");
            }

            return md5.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    private MD5() {
        throw new UnsupportedOperationException(
                "Should not create instance of Util class. Please use as static..");
    }
}
