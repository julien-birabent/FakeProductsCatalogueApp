package com.julienbirabent.fakeproductscatalogue.data.repository.product

import com.julienbirabent.fakeproductscatalogue.app.PRODUCT_COLLECTION_NAME
import com.julienbirabent.fakeproductscatalogue.app.ThisApplication
import com.julienbirabent.fakeproductscatalogue.app.WISHLIST_COLLECTION_NAME
import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import com.julienbirabent.fakeproductscatalogue.data.repository.BaseRepository
import com.julienbirabent.fakeproductscatalogue.data.repository.ProductRepository
import com.julienbirabent.fakeproductscatalogue.data.source.NoSQLDataSource
import com.julienbirabent.fakeproductscatalogue.di.DatabaseInfo
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class ProductRepositoryImpl @Inject constructor(
    override val dataSource: NoSQLDataSource
) :
    BaseRepository(),
    ProductRepository {

    init {
        ThisApplication.applicationComponent()?.inject(this)
    }

    @Inject
    @field:DatabaseInfo(PRODUCT_COLLECTION_NAME)
    override lateinit var productCollectionPath: String

    @Inject
    @field:DatabaseInfo(WISHLIST_COLLECTION_NAME)
    override lateinit var wishListCollectionPath: String

    override fun addProduct(model: Product): Single<Product> {
        return dataSource.addNewValue(productCollectionPath, model)
    }

    override fun getAllProducts(): Observable<List<Product>> {
        return dataSource.getCollection(productCollectionPath, Product::class.java)
    }

    override fun getProduct(id: String): Observable<Product> {
        return dataSource.getDocument(productCollectionPath, id, Product::class.java)
    }

    override fun deleteProduct(model: Product): Single<Product> {
        return dataSource.deleteDocument(productCollectionPath, model.uid, model)
    }

    override fun addToWishList(model: Product): Single<Product> {
        return dataSource.addNewValue(wishListCollectionPath, model)
    }

    override fun getWishList(): Observable<List<Product>> {
        return dataSource.getCollection(wishListCollectionPath, Product::class.java)
    }

    override fun emptyWishList(): Single<*> {
        return getWishList()
            .flatMapIterable { it }
            .flatMap { deleteProduct(it).toObservable() }
            .toList()
    }

}