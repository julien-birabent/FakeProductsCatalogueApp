package com.julienbirabent.fakeproductscatalogue.di.module

import com.julienbirabent.fakeproductscatalogue.app.PRODUCT_COLLECTION_NAME
import com.julienbirabent.fakeproductscatalogue.app.WISHLIST_COLLECTION_NAME
import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import com.julienbirabent.fakeproductscatalogue.data.repository.SimpleRepository
import com.julienbirabent.fakeproductscatalogue.data.repository.product.ProductRepository
import com.julienbirabent.fakeproductscatalogue.data.repository.product.WishListRepository
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
    fun provideProductRepository(
        dataSource: NoSQLDataSource,
        @DatabaseInfo(PRODUCT_COLLECTION_NAME) collectionName: String
    ): SimpleRepository<Product> =
        ProductRepository(dataSource, collectionName)

    @Provides
    @Singleton
    fun provideWishListRepository(
        dataSource: NoSQLDataSource,
        @DatabaseInfo(WISHLIST_COLLECTION_NAME) collectionName: String
    ): WishListRepository = WishListRepository(dataSource, collectionName)
}