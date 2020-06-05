package com.julienbirabent.fakeproductscatalogue.ui.fragment

import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModelProvider
import com.julienbirabent.fakeproductscatalogue.R
import com.julienbirabent.fakeproductscatalogue.databinding.FragmentMainBinding
import com.julienbirabent.fakeproductscatalogue.ui.base.BaseFragment
import com.julienbirabent.fakeproductscatalogue.viewmodel.ProductListViewModel

class MainFragment : BaseFragment<FragmentMainBinding, ProductListViewModel>() {
    override var viewModelBindingVariable: Int = BR.viewModel
    override var layoutResId: Int = R.layout.fragment_main

    override fun provideViewModel(): ProductListViewModel {
        return ViewModelProvider(this, viewModelFactory).get(ProductListViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        hideNavigateUpButton()
        actionBarTitle(getString(R.string.app_name))
    }
}