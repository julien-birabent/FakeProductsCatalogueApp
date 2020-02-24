package com.julienbirabent.fakeproductscatalogue.ui.fragment

import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModelProvider
import com.julienbirabent.fakeproductscatalogue.R
import com.julienbirabent.fakeproductscatalogue.databinding.FragmentMainBinding
import com.julienbirabent.fakeproductscatalogue.ui.base.BaseFragment
import com.julienbirabent.fakeproductscatalogue.viewmodel.MainViewModel

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {
    override var viewModelBindingVariable: Int = BR.viewModel
    override var layoutResId: Int = R.layout.fragment_main

    override fun provideViewModel(): MainViewModel {
        return ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        hideNavigateUpButton()
        actionBarTitle(getString(R.string.app_name))
    }
}