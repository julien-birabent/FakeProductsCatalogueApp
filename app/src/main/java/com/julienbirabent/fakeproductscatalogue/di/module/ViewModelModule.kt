package com.julienbirabent.fakeproductscatalogue.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.julienbirabent.fakeproductscatalogue.di.ViewModelKey
import com.julienbirabent.fakeproductscatalogue.viewmodel.ProductListViewModel
import com.julienbirabent.fakeproductscatalogue.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProductListViewModel::class)
    abstract fun bindWishListViewModel(viewModel: ProductListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}