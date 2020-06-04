package com.julienbirabent.fakeproductscatalogue.data.repository.product

import com.julienbirabent.fakeproductscatalogue.app.ThisApplication
import com.julienbirabent.fakeproductscatalogue.data.RandomProductsGenerator
import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class ProductRepositoryImpl @Inject constructor(private val data: RandomProductsGenerator) :
    ProductRepository {

    init {
        ThisApplication.applicationComponent()?.inject(this)
    }

    override fun getAllProducts(): Flowable<List<Product>> {
        return Flowable.just(data.generateRandomProductList(20))
    }

}