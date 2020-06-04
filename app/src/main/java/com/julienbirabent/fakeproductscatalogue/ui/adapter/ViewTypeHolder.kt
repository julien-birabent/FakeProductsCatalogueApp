package com.julienbirabent.fakeproductscatalogue.ui.adapter

data class ViewTypeHolder<ViewData, Callback>(
    val viewData: ViewData,
    val layoutResId: Int,
    val callback: Callback? = null
) {
    override fun equals(other: Any?): Boolean {
        if (other === this) return true
        with(other as ViewTypeHolder<*, *>) {
            return this@ViewTypeHolder.viewData == this.viewData
        }
    }

    override fun hashCode(): Int {
        return viewData.hashCode()
    }
}