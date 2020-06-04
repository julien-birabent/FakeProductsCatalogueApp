package com.julienbirabent.fakeproductscatalogue.ui.adapter

import com.julienbirabent.fakeproductscatalogue.ui.item.ItemHoldingExtraData

abstract class ViewTypeHolderAssembler<InputModel, ViewDataHolder : ItemHoldingExtraData<InputModel>, Callback> {

    abstract fun assembleItemViewTypeHolder(
        dataModel: InputModel,
        callback: Callback? = null
    ): ViewTypeHolder<ItemHoldingExtraData<InputModel>, Callback>

    protected abstract fun assembleViewDataHolder(dataModel: InputModel): ItemHoldingExtraData<InputModel>
}