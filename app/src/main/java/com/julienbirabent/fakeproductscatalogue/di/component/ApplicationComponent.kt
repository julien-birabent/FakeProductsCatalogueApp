package com.julienbirabent.fakeproductscatalogue.di.component

import android.app.Application
import com.julienbirabent.fakeproductscatalogue.app.ThisApplication
import com.julienbirabent.fakeproductscatalogue.data.source.firestore.FireStoreDataSource
import com.julienbirabent.fakeproductscatalogue.di.module.*
import com.julienbirabent.fakeproductscatalogue.domain.UseCase
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
        DataSourceModule::class,
        RepositoryModule::class]
)
interface ApplicationComponent {

    fun inject(application: ThisApplication)

    fun inject(useCase: UseCase.Injector)

    fun inject(fireStoreDataSource: FireStoreDataSource.Injector)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}