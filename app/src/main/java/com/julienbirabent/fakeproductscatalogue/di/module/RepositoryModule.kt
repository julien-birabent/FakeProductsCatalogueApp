package com.julienbirabent.fakeproductscatalogue.di.module

import com.julienbirabent.fakeproductscatalogue.app.PRODUCT_COLLECTION_NAME
import com.julienbirabent.fakeproductscatalogue.app.WISHLIST_COLLECTION_NAME
import com.julienbirabent.fakeproductscatalogue.data.repository.ProductRepository
import com.julienbirabent.fakeproductscatalogue.data.repository.product.ProductRepositoryImpl
import com.julienbirabent.fakeproductscatalogue.data.source.NoSQLDataSource
import com.julienbirabent.fakeproductscatalogue.di.DatabaseInfo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @DatabaseInfo(PRODUCT_COLLECTION_NAME)
    fun provideProductCollectionName(): String = PRODUCT_COLLECTION_NAME

    @Provides
    @DatabaseInfo(WISHLIST_COLLECTION_NAME)
    fun provideWishListCollectionName(): String = WISHLIST_COLLECTION_NAME

    @Provides
    @Singleton
    fun provideProductRepository(dataSource: NoSQLDataSource): ProductRepository =
        ProductRepositoryImpl(dataSource)
}