package github.nisrulz.androidutils.ktx.misc


fun String.toBoolean() = when (this.toLowerCase()) {
    "y", "yes", "true" -> true
    "n", "no", "false" -> false
    else -> throw IllegalArgumentException("Unsupported Value: '$this'")
}
