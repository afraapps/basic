@file:Suppress("NOTHING_TO_INLINE", "unused")

package org.jetbrains.anko

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.view.View
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.annotation.Dimension
import androidx.fragment.app.Fragment

fun Resources.Theme.attr(@AttrRes attribute: Int): TypedValue {
    val typedValue = TypedValue()
    if (!resolveAttribute(attribute, typedValue, true)) {
        throw IllegalArgumentException("Failed to resolve attribute: $attribute")
    }

    return typedValue
}

@ColorInt
fun Resources.Theme.color(@AttrRes attribute: Int): Int {
    val attr = attr(attribute)
    if (attr.type < TypedValue.TYPE_FIRST_COLOR_INT || attr.type > TypedValue.TYPE_LAST_COLOR_INT) {
        throw IllegalArgumentException("Attribute value type is not color: $attribute")
    }
    return attr.data
}

fun Context.attr(@AttrRes attribute: Int): TypedValue = theme.attr(attribute)

@Dimension(unit = Dimension.PX)
fun Context.dimenAttr(@AttrRes attribute: Int): Int =
    TypedValue.complexToDimensionPixelSize(attr(attribute).data, resources.displayMetrics)

@ColorInt
fun Context.colorAttr(@AttrRes attribute: Int): Int = theme.color(attribute)


@Dimension(unit = Dimension.PX)
inline fun AnkoContext<*>.dimenAttr(@AttrRes attribute: Int): Int = ctx.dimenAttr(attribute)

@ColorInt
inline fun AnkoContext<*>.colorAttr(@AttrRes attribute: Int): Int = ctx.colorAttr(attribute)

inline fun AnkoContext<*>.attr(@AttrRes attribute: Int): TypedValue = ctx.attr(attribute)


@Dimension(unit = Dimension.PX)
inline fun View.dimenAttr(@AttrRes attribute: Int): Int = context.dimenAttr(attribute)

@ColorInt
inline fun View.colorAttr(@AttrRes attribute: Int): Int = context.colorAttr(attribute)

inline fun View.attr(@AttrRes attribute: Int): TypedValue = context.attr(attribute)


@Dimension(unit = Dimension.PX)
inline fun Fragment.dimenAttr(@AttrRes attribute: Int): Int = act.dimenAttr(attribute)

@ColorInt
inline fun Fragment.colorAttr(@AttrRes attribute: Int): Int = act.colorAttr(attribute)

inline fun Fragment.attr(@AttrRes attribute: Int): TypedValue = act.attr(attribute)
