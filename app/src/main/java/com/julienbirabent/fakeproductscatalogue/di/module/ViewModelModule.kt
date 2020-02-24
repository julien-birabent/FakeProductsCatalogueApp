package com.julienbirabent.fakeproductscatalogue.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.julienbirabent.fakeproductscatalogue.di.ViewModelKey
import com.julienbirabent.fakeproductscatalogue.viewmodel.MainViewModel
import com.julienbirabent.fakeproductscatalogue.viewmodel.ProductDetailsViewModel
import com.julienbirabent.fakeproductscatalogue.viewmodel.ViewModelFactory
import com.julienbirabent.fakeproductscatalogue.viewmodel.WishListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    /**Every time we need a new view model to be injected, we have to provide it in this module
     * with the following template :
     * @Binds
     * @IntoMap
     *@ViewModelKey(ExampleViewModel::class)
     *abstract fun bindExampleViewModel(viewModel: ExampleViewModel): ViewModel
     *
     *
     * */

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProductDetailsViewModel::class)
    abstract fun bindProductDetailsViewModel(viewModel: ProductDetailsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WishListViewModel::class)
    abstract fun bindWishListViewModel(viewModel: WishListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}