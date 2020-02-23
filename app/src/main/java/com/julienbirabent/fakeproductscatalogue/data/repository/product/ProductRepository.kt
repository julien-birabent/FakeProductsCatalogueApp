package com.julienbirabent.fakeproductscatalogue.data.repository.product

import com.julienbirabent.fakeproductscatalogue.app.PRODUCT_COLLECTION_NAME
import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import com.julienbirabent.fakeproductscatalogue.data.repository.BaseRepository
import com.julienbirabent.fakeproductscatalogue.data.repository.SimpleRepository
import com.julienbirabent.fakeproductscatalogue.data.source.NoSQLDataSource
import com.julienbirabent.fakeproductscatalogue.di.DatabaseInfo
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepository @Inject constructor(
    override val dataSource: NoSQLDataSource,
    override val collectionName: String
) :
    BaseRepository<Product>(),
    SimpleRepository<Product> {

    override fun add(model: Product): Single<Product> {
        return dataSource.addNewValue(collectionName, model)
    }

    override fun getAll(): Observable<List<Product>> {
        return dataSource.getCollection(collectionName, Product::class.java)
    }

    override fun get(id: String): Observable<Product> {
        return dataSource.getDocument(collectionName, id, Product::class.java)
    }

}