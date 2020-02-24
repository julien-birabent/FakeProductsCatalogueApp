package com.julienbirabent.fakeproductscatalogue.data.repository

import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import com.julienbirabent.fakeproductscatalogue.rx.firebase.None
import io.reactivex.Observable
import io.reactivex.Single

interface ProductRepository {

    val productCollectionPath: String
    val wishListCollectionPath: String

    fun addProduct(model: Product): Single<Product>

    fun addToWishList(model: Product): Single<Product>

    fun getAllProducts(): Observable<List<Product>>

    fun getWishList(): Observable<List<Product>>

    fun getProduct(id: String): Observable<Product>

    fun deleteProduct(model: Product): Single<Product>

    fun emptyWishList(): Single<*>

}