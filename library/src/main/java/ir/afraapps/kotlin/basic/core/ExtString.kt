package ir.afraapps.kotlin.basic.core

import android.graphics.Color
import android.text.Spanned
import androidx.annotation.ColorInt
import androidx.core.graphics.toColorInt
import androidx.core.text.HtmlCompat
import java.math.BigInteger
import java.security.MessageDigest

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 4/24/20.
 */

fun String.isMobileNumber(): Boolean {
    return matches(Regex("^(((\\+|00)98)|98|0)?9[01239]\\d{8}$"))
}


fun String.isEmail(): Boolean {
    return matches(Regex("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"))
}


fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
}


infix fun String.shl(bitCount: Int) = map {
    it.toInt().shl(bitCount)
}.joinToString(separator = "") {
    it.toChar().toString()
}

infix fun String.shr(bitCount: Int) = map {
    it.toInt().shr(bitCount)
}.joinToString(separator = "") {
    it.toChar().toString()
}


fun String.fromHtmlCompat(): Spanned {
    return HtmlCompat.fromHtml(this, HtmlCompat.FROM_HTML_MODE_COMPACT)
}

@ColorInt
fun String?.toColorIntOrDefault(defaultColor: Int): Int = kotlin.runCatching { Color.parseColor(this) }.getOrDefault(defaultColor)