package github.nisrulz.androidutils.ktx.view

import android.view.LayoutInflater
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import github.nisrulz.androidutils.ktx.R

fun BottomNavigationView.addBadge(index: Int, value: Int) {
    val bottomNavigationMenuView = this.getChildAt(0) as BottomNavigationMenuView
    val v = bottomNavigationMenuView.getChildAt(bottomNavigationMenuView.childCount - index)
    val itemView = v as BottomNavigationItemView

    val badge = LayoutInflater.from(this.context)
            .inflate(R.layout.notification_badge, bottomNavigationMenuView, false)

    val textView = badge.findViewById<TextView>(R.id.textView_notifications_badge)
    textView.text = value.toString()
    itemView.addView(badge)
}

/**
 * Remove the badge
 * @receiver BottomNavigationView
 * @param index Int index of the tab where the badge was added
 * @return Unit
 */
fun BottomNavigationView.removeBadge(index: Int) {
    val menuView = this.getChildAt(0) as BottomNavigationMenuView
    val item = menuView.getChildAt(index - 1) as BottomNavigationItemView
    if (item.childCount == 3) {
        // Remove the last added view i.e badge
        item.removeViewAt(item.childCount - 1)
    }
}