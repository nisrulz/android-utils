package github.nisrulz.androidutils.ktx.misc


fun String.removeLastChar(endingChar: String): String {
    var stringText = this
    if (!stringText.isNullOrEmpty()) {
        if (stringText.endsWith(endingChar)) {
            stringText = stringText.substring(0, stringText.length - 1)
        }
    }
    return stringText
}

fun String.toTitleCase(): String {
    val titleCase = StringBuilder()
    var nextTitleCase = true

    for (c in this.toCharArray()) {
        var character = c
        if (Character.isSpaceChar(c)) {
            nextTitleCase = true
        } else if (nextTitleCase) {
            character = Character.toTitleCase(c)
            nextTitleCase = false
        }
        titleCase.append(character)
    }

    return titleCase.toString()
}