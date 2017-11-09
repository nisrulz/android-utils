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

public class HTTPResponseInfo {

    private int statusCode;

    private String statusDescription;

    private String statusText;

    private String type;

    public HTTPResponseInfo() {
        this.statusCode = 0;
        this.statusText = "-";
        this.statusDescription = "-";
        this.type = "-";
    }

    public int getStatusCode() {
        return statusCode;
    }

    void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getStatusText() {
        return statusText;
    }

    void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getType() {
        return type;
    }

    void setType(String type) {
        this.type = type;
    }
}
