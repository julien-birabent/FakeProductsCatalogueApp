package com.julienbirabent.fakeproductscatalogue.di.module

import com.julienbirabent.fakeproductscatalogue.ui.fragment.CatalogueListFragment
import com.julienbirabent.fakeproductscatalogue.ui.fragment.MainFragment
import com.julienbirabent.fakeproductscatalogue.ui.fragment.ProductDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentProvider {

    @ContributesAndroidInjector
    abstract fun contributeMainFragment() : MainFragment

    @ContributesAndroidInjector
    abstract fun contributeCatalogueListFragment() : CatalogueListFragment

    @ContributesAndroidInjector
    abstract fun contributeProductDetailsFragment() : ProductDetailsFragment
}