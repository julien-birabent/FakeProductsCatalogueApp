package com.julienbirabent.fakeproductscatalogue.data.repository.product

import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import io.reactivex.Observable

interface ProductRepository {
    fun getAllProducts(): Observable<List<Product>>

}