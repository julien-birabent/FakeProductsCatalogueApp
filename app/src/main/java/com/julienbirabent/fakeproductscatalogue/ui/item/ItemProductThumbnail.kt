package com.julienbirabent.fakeproductscatalogue.ui.item

import com.julienbirabent.fakeproductscatalogue.data.entity.ImageResource

class ItemProductThumbnail<T>(
    var name: String? = "",
    var imageResource: ImageResource<*>?,
    extraData: T
) : ItemHoldingExtraData<T>(extraData)