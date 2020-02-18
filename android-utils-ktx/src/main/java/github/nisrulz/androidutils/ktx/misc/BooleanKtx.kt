package github.nisrulz.androidutils.ktx.misc

import java.util.*


fun String.toBoolean() = when (this.toLowerCase(Locale.getDefault())) {
    "y", "yes", "true" -> true
    "n", "no", "false" -> false
    else -> throw IllegalArgumentException("Unsupported Value: '$this'")
}
