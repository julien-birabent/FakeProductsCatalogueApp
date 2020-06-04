package com.julienbirabent.fakeproductscatalogue.data.repository.product

import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import io.reactivex.Flowable

interface ProductRepository {
    fun getAllProducts(): Flowable<List<Product>>

}