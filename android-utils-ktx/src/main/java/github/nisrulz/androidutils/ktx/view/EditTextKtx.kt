package github.nisrulz.androidutils.ktx.view

import android.renderscript.ScriptGroup
import android.text.InputFilter
import android.text.Spanned
import android.text.method.PasswordTransformationMethod
import android.text.method.ReplacementTransformationMethod
import android.widget.EditText
import java.util.*
import kotlin.collections.ArrayList


fun EditText.uppercase() {
    transformationMethod = object : ReplacementTransformationMethod() {
        private val lower = charArrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
        private val upper = charArrayOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')

        override fun getOriginal() = lower

        override fun getReplacement() = upper
    }
}

fun EditText.lowercase() {
    transformationMethod = object : ReplacementTransformationMethod() {
        private val lower = charArrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
        private val upper = charArrayOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')

        override fun getOriginal() = upper

        override fun getReplacement() = lower
    }
}

fun EditText.passwordToggledVisible() {
    val selection = selectionStart
    transformationMethod = if (transformationMethod == null) PasswordTransformationMethod() else null
    setSelection(selection)
}

var EditText.value: String
    get() = text.toString()
    set(value) = setText(value)

fun EditText.disallowEmojisAndSpecialChars() {
    val emojiFilter = InputFilter { source: CharSequence, start: Int, end: Int, dest: Spanned?, dstart: Int, dend: Int ->
        var index = start
        while (index < end) {
            val type = Character.getType(source[index])
            if (type == Character.SURROGATE.toInt() || type == Character.NON_SPACING_MARK.toInt() || type == Character.OTHER_SYMBOL.toInt()) {
                ""
            }
            index++
        }
        null
    }

    val filterList: ArrayList<InputFilter> = ArrayList(this.filters.size)
    this.filters.asSequence().map { filterList.add(it) }
    filterList.add(emojiFilter)
    filters = filterList.toArray(arrayOf<InputFilter>())
}