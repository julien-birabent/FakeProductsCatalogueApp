package com.julienbirabent.fakeproductscatalogue.ui.item

import com.julienbirabent.fakeproductscatalogue.data.entity.ImageResource
import com.julienbirabent.fakeproductscatalogue.ui.adapter.DataBindingRecyclerviewAdapter

class ItemProductSummary<T>(
    var name: String? = "",
    var imageResource: ImageResource<*>?,
    var price: String? = "",
    var shortDescription: String? = "",
    var isOutOfStock: Boolean = false,
    var colorAdapter: DataBindingRecyclerviewAdapter,
    extraData: T
) : ItemHoldingExtraData<T>(extraData)