package com.julienbirabent.fakeproductscatalogue.di.module

import com.julienbirabent.fakeproductscatalogue.data.RandomProductsGenerator
import com.julienbirabent.fakeproductscatalogue.data.repository.product.ProductRepository
import com.julienbirabent.fakeproductscatalogue.data.repository.product.ProductRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideProductRepository(data: RandomProductsGenerator): ProductRepository =
        ProductRepositoryImpl(data)
}