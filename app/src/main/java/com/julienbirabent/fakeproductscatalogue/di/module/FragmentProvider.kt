package com.julienbirabent.fakeproductscatalogue.di.module

import com.julienbirabent.fakeproductscatalogue.ui.fragment.*
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentProvider {

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment

    @ContributesAndroidInjector
    abstract fun contributeCatalogueListFragment(): CatalogueListFragment

    @ContributesAndroidInjector
    abstract fun contributeWishListFragment(): WishListFragment

    @ContributesAndroidInjector
    abstract fun contributeProductDetailsVariantFragment(): ProductDetailsFromWishListFragment

    @ContributesAndroidInjector
    abstract fun contributeProductDetailsFragment(): ProductDetailsFragment
}