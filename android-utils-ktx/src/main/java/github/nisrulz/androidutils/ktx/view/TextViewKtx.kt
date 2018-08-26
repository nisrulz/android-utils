package github.nisrulz.androidutils.ktx.view

import android.text.method.LinkMovementMethod
import android.widget.TextView
import github.nisrulz.androidutils.ktx.misc.getHtmlFormattedSpanned

/**
 * Set HTML String with links enabled
 */
fun TextView.setHtmlText(htmlString: String) {
    // Enables all anchor links inside the text view
    this.movementMethod = LinkMovementMethod.getInstance()
    this.text = htmlString.getHtmlFormattedSpanned()
}