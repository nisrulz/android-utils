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

package github.nisrulz.androidutils.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;

/**
 * The type Web view utils.
 *
 * @author Nishant Srivastava
 */
public class WebViewUtils {

    /**
     * Enable java script.
     *
     * @param webView the web view
     * @param enabled the enabled
     */
    @SuppressLint("SetJavaScriptEnabled")
    public static void enableJavaScript(WebView webView, boolean enabled) {
        if (webView != null) {
            webView.getSettings().setJavaScriptEnabled(enabled);
        }
    }

    /**
     * Enable web view debugging.
     *
     * @param enabled the enabled
     */
    public static void enableWebViewDebugging(boolean enabled) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(enabled);
        }
    }

    /**
     * Sync cookie with system browser.
     *
     * @param context the context
     */
    @SuppressWarnings("deprecation")
    public static void syncCookieWithSystemBrowser(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            CookieManager.getInstance().flush();
        } else {
            CookieSyncManager.createInstance(context);
            CookieSyncManager.getInstance().startSync();
            CookieSyncManager.getInstance().sync();
        }
    }

    private WebViewUtils() {
        throw new UnsupportedOperationException(
                "Should not create instance of Util class. Please use as static..");
    }
}
