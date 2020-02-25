package com.julienbirabent.fakeproductscatalogue.ui.fragment

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.julienbirabent.fakeproductscatalogue.BR
import com.julienbirabent.fakeproductscatalogue.R
import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import com.julienbirabent.fakeproductscatalogue.databinding.FragmentCatalogueListBinding
import com.julienbirabent.fakeproductscatalogue.ui.adapter.ItemSelectionCallback
import com.julienbirabent.fakeproductscatalogue.ui.adapter.OmniAdapter
import com.julienbirabent.fakeproductscatalogue.ui.adapter.ViewTypeHolder
import com.julienbirabent.fakeproductscatalogue.ui.base.BaseFragment
import com.julienbirabent.fakeproductscatalogue.ui.extension.createItemSelectionCallback
import com.julienbirabent.fakeproductscatalogue.ui.item.ItemProductThumbnail
import com.julienbirabent.fakeproductscatalogue.viewmodel.MainViewModel

class CatalogueListFragment : BaseFragment<FragmentCatalogueListBinding, MainViewModel>() {
    override var viewModelBindingVariable: Int = BR.viewModel
    override var layoutResId: Int = R.layout.fragment_catalogue_list

    override fun provideViewModel(): MainViewModel {
        return ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    }

    private val adapter by lazy { OmniAdapter() }

    override fun setDataBindingVariables(binding: ViewDataBinding) {
        super.setDataBindingVariables(binding)
        layoutBinding.setVariable(BR.adapter, adapter)
    }

    override fun onStart() {
        super.onStart()

        viewModel.catalogue.observe(this, Observer {
            it.data?.let { list -> adapter.updateList(createList(list)) }
        })
    }

    private fun createList(products: List<Product>): List<ViewTypeHolder<ItemProductThumbnail<Product>, ItemSelectionCallback<Product>>> {
        return products.map { createItemViewTypeHolder(it) }
    }

    private fun createItemViewTypeHolder(item: Product): ViewTypeHolder<ItemProductThumbnail<Product>, ItemSelectionCallback<Product>> {
        return ViewTypeHolder(
            viewData = ItemProductThumbnail(item.title, item.imageResource, item),
            layoutResId = R.layout.item_product_thumbnail,
            callback = createItemSelectionCallback {
                findNavController().navigate(MainFragmentDirections.openProductDetails(item))
            }
        )
    }

}