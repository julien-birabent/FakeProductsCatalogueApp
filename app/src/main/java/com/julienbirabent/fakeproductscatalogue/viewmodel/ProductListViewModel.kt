package com.julienbirabent.fakeproductscatalogue.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import com.julienbirabent.fakeproductscatalogue.data.repository.product.ProductRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductListViewModel @Inject constructor(
    productRepository: ProductRepository
) : ViewModel() {

    private val _productList = productRepository.getAllProducts()

    val productList: LiveData<List<Product>> = LiveDataReactiveStreams.fromPublisher(_productList)

}