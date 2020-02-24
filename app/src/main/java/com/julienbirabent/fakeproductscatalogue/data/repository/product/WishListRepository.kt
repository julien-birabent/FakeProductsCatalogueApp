package com.julienbirabent.fakeproductscatalogue.data.repository.product

import com.julienbirabent.fakeproductscatalogue.data.source.NoSQLDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WishListRepository @Inject constructor(dataSource: NoSQLDataSource, collectionName: String) :
    ProductRepository(dataSource, collectionName)