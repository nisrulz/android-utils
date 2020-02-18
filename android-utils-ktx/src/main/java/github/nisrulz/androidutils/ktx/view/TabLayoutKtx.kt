package github.nisrulz.androidutils.ktx.view

import android.content.res.Resources
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.MODE_FIXED

private fun TabLayout.switchToFixedTabModeIfNumberOfTabsFitInScreen() {
    addOnLayoutChangeListener { _, _, _, _, _, _, _, _, _ ->
        var totalWidth = 0
        var maxWidth = 0
        for (i in 0 until tabCount) {
            val tabWidth = (getChildAt(0) as ViewGroup).getChildAt(i)?.width
            tabWidth?.let {
                totalWidth += tabWidth
                maxWidth = Math.max(maxWidth, tabWidth)
            }
        }
        val screenWidth = Resources.getSystem().displayMetrics.widthPixels
        if (totalWidth < screenWidth && screenWidth / tabCount >= maxWidth) {
            tabMode = MODE_FIXED
        }
    }
}