package com.julienbirabent.fakeproductscatalogue.ui.fragment

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.julienbirabent.fakeproductscatalogue.R
import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import com.julienbirabent.fakeproductscatalogue.databinding.FragmentProductListBinding
import com.julienbirabent.fakeproductscatalogue.ui.adapter.DataBindingRecyclerviewAdapter
import com.julienbirabent.fakeproductscatalogue.ui.adapter.ItemSelectionCallback
import com.julienbirabent.fakeproductscatalogue.ui.adapter.ProductSummaryViewTypeHolderAssembler
import com.julienbirabent.fakeproductscatalogue.ui.base.BaseFragment
import com.julienbirabent.fakeproductscatalogue.ui.extension.createItemSelectionCallback
import com.julienbirabent.fakeproductscatalogue.viewmodel.ProductListViewModel

class ProductListFragment : BaseFragment<FragmentProductListBinding, ProductListViewModel>() {
    override var viewModelBindingVariable: Int = BR.viewModel
    override var layoutResId: Int = R.layout.fragment_product_list

    override fun provideViewModel(): ProductListViewModel {
        return ViewModelProvider(this, viewModelFactory).get(ProductListViewModel::class.java)
    }

    private val viewTypeHolderAssembler by lazy { ProductSummaryViewTypeHolderAssembler() }
    private val adapter by lazy { DataBindingRecyclerviewAdapter() }

    override fun setDataBindingVariables(binding: ViewDataBinding) {
        super.setDataBindingVariables(binding)
        layoutBinding.setVariable(BR.adapter, adapter)
    }

    override fun onStart() {
        super.onStart()

        viewModel.productList.observe(viewLifecycleOwner, Observer {
            adapter.updateList(
                it.map { product ->
                    viewTypeHolderAssembler.assembleItemViewTypeHolder(
                        product,
                        productDetailsNavigationDelegate(product)
                    )
                }
            )
        })
    }

    private fun productDetailsNavigationDelegate(product: Product): ItemSelectionCallback<Product> {
        return createItemSelectionCallback {
            findNavController().navigate(
                MainFragmentDirections.openProductDetails(product)
            )
        }
    }
}