package com.julienbirabent.fakeproductscatalogue.ui.extension

import com.julienbirabent.fakeproductscatalogue.ui.adapter.ItemSelectionCallback

fun <T> createItemSelectionCallback(block: (T) -> Unit): ItemSelectionCallback<T> {
    return object : ItemSelectionCallback<T> {
        override fun onItemSelected(item: T) {
            block.invoke(item)
        }
    }
}
