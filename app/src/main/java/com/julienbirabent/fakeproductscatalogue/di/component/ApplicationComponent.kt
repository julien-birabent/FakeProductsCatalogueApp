package com.julienbirabent.fakeproductscatalogue.di.component

import android.app.Application
import com.julienbirabent.fakeproductscatalogue.app.ThisApplication
import com.julienbirabent.fakeproductscatalogue.data.repository.product.ProductRepositoryImpl
import com.julienbirabent.fakeproductscatalogue.di.module.ActivityBuilderModule
import com.julienbirabent.fakeproductscatalogue.di.module.AppModule
import com.julienbirabent.fakeproductscatalogue.di.module.RepositoryModule
import com.julienbirabent.fakeproductscatalogue.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ViewModelModule::class,
        ActivityBuilderModule::class,
        RepositoryModule::class]
)
interface ApplicationComponent {

    fun inject(application: ThisApplication)

    fun inject(productRepository: ProductRepositoryImpl)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}