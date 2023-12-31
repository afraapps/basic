/*
 * Copyright 2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:Suppress("NOTHING_TO_INLINE", "unused")

package org.jetbrains.anko

import android.content.Context
import android.content.DialogInterface
import androidx.fragment.app.Fragment

inline fun <D : DialogInterface> AnkoContext<*>.selector(
    noinline factory: AlertBuilderFactory<D>,
    title: CharSequence? = null,
    items: List<CharSequence>,
    noinline onClick: (DialogInterface, CharSequence, Int) -> Unit
) = ctx.selector(factory, title, items, onClick)

inline fun <D : DialogInterface> Fragment.selector(
    noinline factory: AlertBuilderFactory<D>,
    title: CharSequence? = null,
    items: List<CharSequence>,
    noinline onClick: (DialogInterface, CharSequence, Int) -> Unit
) = requireActivity().selector(factory, title, items, onClick)

fun <D : DialogInterface> Context.selector(
    factory: AlertBuilderFactory<D>,
    title: CharSequence? = null,
    items: List<CharSequence>,
    onClick: (DialogInterface, CharSequence, Int) -> Unit
) {
    with(factory(this)) {
        if (title != null) {
            this.title = title
        }
        items(items, onClick)
        show()
    }
}
