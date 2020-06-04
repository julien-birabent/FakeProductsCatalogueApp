package com.julienbirabent.fakeproductscatalogue.ui.fragment

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.julienbirabent.fakeproductscatalogue.R
import com.julienbirabent.fakeproductscatalogue.data.entity.product.ColorResource
import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import com.julienbirabent.fakeproductscatalogue.databinding.FragmentProductListBinding
import com.julienbirabent.fakeproductscatalogue.ui.adapter.ItemSelectionCallback
import com.julienbirabent.fakeproductscatalogue.ui.adapter.OmniAdapter
import com.julienbirabent.fakeproductscatalogue.ui.adapter.ViewTypeHolder
import com.julienbirabent.fakeproductscatalogue.ui.base.BaseFragment
import com.julienbirabent.fakeproductscatalogue.ui.extension.createItemSelectionCallback
import com.julienbirabent.fakeproductscatalogue.ui.item.ItemProductDetails
import com.julienbirabent.fakeproductscatalogue.viewmodel.ProductListViewModel

class ProductListFragment : BaseFragment<FragmentProductListBinding, ProductListViewModel>() {
    override var viewModelBindingVariable: Int = BR.viewModel
    override var layoutResId: Int = R.layout.fragment_product_list

    override fun provideViewModel(): ProductListViewModel {
        return ViewModelProvider(this, viewModelFactory).get(ProductListViewModel::class.java)
    }

    private val adapter by lazy { OmniAdapter() }

    override fun setDataBindingVariables(binding: ViewDataBinding) {
        super.setDataBindingVariables(binding)
        layoutBinding.setVariable(BR.adapter, adapter)
    }

    override fun onStart() {
        super.onStart()

    }

    private fun createAdapterList(products: List<Product>): List<ViewTypeHolder<ItemProductDetails<Product>, ItemSelectionCallback<Product>>> {
        return products.map { createItemViewTypeHolder(it) }
    }

    private fun createItemViewTypeHolder(item: Product): ViewTypeHolder<ItemProductDetails<Product>, ItemSelectionCallback<Product>> {
        return ViewTypeHolder(
            viewData = createDataViewHolder(item),
            layoutResId = R.layout.item_product_details,
            callback = createItemSelectionCallback {
                findNavController().navigate(MainFragmentDirections.openProductDetails(item))
            }
        )
    }

    private fun createDataViewHolder(item: Product): ItemProductDetails<Product> {
        return ItemProductDetails(
            name = item.title,
            imageResource = item.imageResource,
            isOutOfStock = item.quantity <= 0,
            price = item.price.toString(),
            shortDescription = item.description,
            extraData = item,
            colorAdapter = createColorAdapter(item)
        )
    }

    private fun createColorAdapter(it: Product): OmniAdapter {
        return OmniAdapter().apply {
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