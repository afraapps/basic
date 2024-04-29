package ir.afraapps.kotlin.basic.view

import android.app.Activity
import android.content.Context
import android.view.View
import ir.afraapps.kotlin.basic.util.property.IntProperty

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 10/16/19.
 */

abstract class AnkoUI(val context: Context) {

    val primaryColorProperty = IntProperty()
    val primaryDarkColorProperty = IntProperty()
    val primaryLightColorProperty = IntProperty()
    val backgroundColorProperty = IntProperty()
    val background2ColorProperty = IntProperty()
    val background3ColorProperty = IntProperty()

    var colorPrimary: Int by primaryColorProperty
    var colorPrimaryDark: Int by primaryDarkColorProperty
    var colorPrimaryLight: Int by primaryLightColorProperty
    var bgColor: Int by backgroundColorProperty
    var bgColor2: Int by background2ColorProperty
    var bgColor3: Int by background3ColorProperty

    abstract val root: View


    @Suppress("UNCHECKED_CAST")
    fun <T : AnkoUI> bind(): T {
        (context as? Activity)?.setContentView(root)
        return this as T
    }

    val isVisible: Boolean get() = root.visibility == View.VISIBLE

    open fun hide() = let { root.visibility = View.GONE }

    open fun show() = let { root.visibility = View.VISIBLE }


}

fun <T : AnkoUI> Activity.setContentView(ui: T): T {
    setContentView(ui.root)
    return ui
}