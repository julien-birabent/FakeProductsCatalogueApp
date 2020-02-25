package com.julienbirabent.fakeproductscatalogue.ui.fragment

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModelProvider
import com.julienbirabent.fakeproductscatalogue.R
import com.julienbirabent.fakeproductscatalogue.databinding.FragmentWishListBinding
import com.julienbirabent.fakeproductscatalogue.ui.adapter.OmniAdapter
import com.julienbirabent.fakeproductscatalogue.ui.base.BaseFragment
import com.julienbirabent.fakeproductscatalogue.viewmodel.WishListViewModel

class WishListFragment : BaseFragment<FragmentWishListBinding, WishListViewModel>() {
    override var viewModelBindingVariable: Int = BR.viewModel
    override var layoutResId: Int = R.layout.fragment_wish_list

    override fun provideViewModel(): WishListViewModel {
        return ViewModelProvider(this, viewModelFactory).get(WishListViewModel::class.java)
    }

    private val adapter by lazy { OmniAdapter() }

    override fun setDataBindingVariables(binding: ViewDataBinding) {
        super.setDataBindingVariables(binding)
        layoutBinding.setVariable(BR.adapter, adapter)
    }

}