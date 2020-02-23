package com.julienbirabent.fakeproductscatalogue.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
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

    @Provides
    @Singleton
    fun provideSharedPreferences(
        context: Context
    ): SharedPreferences {
        return context.getSharedPreferences("private_shared_preferences", Context.MODE_PRIVATE)
    }
}

