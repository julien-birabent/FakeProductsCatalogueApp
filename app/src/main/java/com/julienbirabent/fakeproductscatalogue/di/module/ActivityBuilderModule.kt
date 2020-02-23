package com.julienbirabent.fakeproductscatalogue.di.module

import com.julienbirabent.fakeproductscatalogue.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    /**
     * For each fragment that we want to inject some of their fields, we need to create a module
     * class named [fragment_name]Provider::class and add it to the array of modules of the activity
     * that is gonna be hosting the fragment. In the fragment provider module, we need to provide
     * the properties that we want to inject with @Provide methods.
     */
    // This is an example
    @ContributesAndroidInjector(modules = [FragmentProvider::class])
    abstract fun bindMainActivity(): MainActivity


}
