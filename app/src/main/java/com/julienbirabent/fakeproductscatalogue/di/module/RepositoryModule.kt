package com.julienbirabent.fakeproductscatalogue.di.module

import com.julienbirabent.fakeproductscatalogue.app.PRODUCT_COLLECTION_NAME
import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import com.julienbirabent.fakeproductscatalogue.data.repository.SimpleRepository
import com.julienbirabent.fakeproductscatalogue.data.repository.product.ProductRepository
import com.julienbirabent.fakeproductscatalogue.data.source.NoSQLDataSource
import com.julienbirabent.fakeproductscatalogue.di.DatabaseInfo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @DatabaseInfo(PRODUCT_COLLECTION_NAME)
    @Singleton
    fun provideProductCollectionName(): String = PRODUCT_COLLECTION_NAME

    @Provides
    @Singleton
    fun provideProductRepository(dataSource: NoSQLDataSource): SimpleRepository<Product> =
        ProductRepository(dataSource)


}