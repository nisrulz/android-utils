package github.nisrulz.androidutils.ktx.misc

import android.annotation.SuppressLint
import android.os.Build
import android.webkit.WebView

@SuppressLint("SetJavaScriptEnabled")
fun WebView?.enableJavaScript(enabled: Boolean) {
    this?.settings?.javaScriptEnabled = enabled
}

fun WebView.enableWebViewDebugging(enabled: Boolean) {
    if (VersionUtils.isApiOrUp(Build.VERSION_CODES.KITKAT)) {
        WebView.setWebContentsDebuggingEnabled(enabled)
    }
}