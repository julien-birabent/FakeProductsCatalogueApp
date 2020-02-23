package com.julienbirabent.fakeproductscatalogue.ui.adapter

interface ItemSelectionCallback<T> {
    fun onItemSelected(item: T)
}