package com.julienbirabent.fakeproductscatalogue.ui.adapter

import com.julienbirabent.fakeproductscatalogue.ui.item.ViewItem

abstract class ViewTypeHolderAssembler<InputModel, ViewDataHolder : ViewItem<InputModel>, Callback> {

    abstract fun assembleItemViewTypeHolder(
        dataModel: InputModel,
        callback: Callback? = null
    ): ViewTypeHolder<ViewItem<InputModel>, Callback>

    protected abstract fun createViewData(dataModel: InputModel): ViewItem<InputModel>
}