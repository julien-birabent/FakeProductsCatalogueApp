package com.julienbirabent.fakeproductscatalogue.viewmodel

import androidx.lifecycle.ViewModel
import com.julienbirabent.fakeproductscatalogue.data.repository.product.ProductRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductListViewModel @Inject constructor(
    productRepository: ProductRepository
) : ViewModel() {


}