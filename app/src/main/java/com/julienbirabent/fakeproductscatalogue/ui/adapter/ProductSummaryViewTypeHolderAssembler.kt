package com.julienbirabent.fakeproductscatalogue.ui.adapter

import com.julienbirabent.fakeproductscatalogue.R
import com.julienbirabent.fakeproductscatalogue.data.entity.product.ColorResource
import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import com.julienbirabent.fakeproductscatalogue.ui.item.ItemHoldingExtraData
import com.julienbirabent.fakeproductscatalogue.ui.item.ItemProductSummary

class ProductSummaryViewTypeHolderAssembler:
    ViewTypeHolderAssembler<Product, ItemProductSummary<Product>, ItemSelectionCallback<Product>>() {

    override fun assembleItemViewTypeHolder(
        dataModel: Product,
        callback: ItemSelectionCallback<Product>?
    ): ViewTypeHolder<ItemHoldingExtraData<Product>, ItemSelectionCallback<Product>> {
        return ViewTypeHolder(
            viewData = assembleViewDataHolder(dataModel),
            layoutResId = R.layout.item_product_details,
            callback = callback
        )
    }

    override fun assembleViewDataHolder(dataModel: Product): ItemHoldingExtraData<Product> {
        return ItemProductSummary(
            name = dataModel.title,
            imageResource = dataModel.imageResource,
            isOutOfStock = dataModel.quantity <= 0,
            price = dataModel.price.toString(),
            shortDescription = dataModel.description,
            extraData = dataModel,
            colorAdapter = createColorAdapter(dataModel)
        )
    }

    private fun createColorAdapter(it: Product): DataBindingRecyclerviewAdapter {
        return DataBindingRecyclerviewAdapter().apply {
            updateList(it.colors.map { colorResource ->
                createColorItemViewTypeHolder(colorResource)
            })
        }
    }

    private fun createColorItemViewTypeHolder(item: ColorResource<*>): ViewTypeHolder<ColorResource<*>, ItemSelectionCallback<*>> {
        return ViewTypeHolder(
            viewData = item,
            layoutResId = R.layout.item_image_thumbnail_mini
        )
    }

}