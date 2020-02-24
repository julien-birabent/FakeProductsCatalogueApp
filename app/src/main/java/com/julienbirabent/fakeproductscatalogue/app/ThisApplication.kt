package com.julienbirabent.fakeproductscatalogue.app

import android.app.Activity
import android.app.Application
import com.julienbirabent.fakeproductscatalogue.di.component.ApplicationComponent
import com.julienbirabent.fakeproductscatalogue.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

const val PRODUCT_COLLECTION_NAME = "catalogue"
const val WISHLIST_COLLECTION_NAME = "wishlist"

class ThisApplication : Application(), HasActivityInjector {

    private lateinit var component: ApplicationComponent

    @Inject
    lateinit var activityDispatchingInjector: DispatchingAndroidInjector<Activity>

    init {
        instance = this
    }

    companion object {
        private var instance: ThisApplication? = null

        fun applicationComponent(): ApplicationComponent? = instance?.component
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent.builder()
            .application(this)
            .build()
        component.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingInjector

}