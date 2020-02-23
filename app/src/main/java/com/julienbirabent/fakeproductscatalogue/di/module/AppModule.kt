package com.julienbirabent.fakeproductscatalogue.di.module

import android.app.Application
import android.content.Context
import com.julienbirabent.fakeproductscatalogue.thread.AppSchedulerProvider
import com.julienbirabent.fakeproductscatalogue.thread.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {

    @Singleton
    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()

    @Singleton
    @Provides
    fun provideContext(application: Application): Context {
        return application
    }
}

