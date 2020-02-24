package com.julienbirabent.fakeproductscatalogue.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import com.julienbirabent.fakeproductscatalogue.domain.common.GetOneByIdUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductDetailsViewModel @Inject constructor(private val getOneByIdUseCase: GetOneByIdUseCase<Product>) :
    ViewModel() {

    private val productId: MutableLiveData<String> = MutableLiveData()

    val product = Transformations.switchMap(productId) { id ->
        getOneByIdUseCase.execute(id).toLiveData()
    }

    fun setProductId(id: String) {
        productId.value = id
    }
}