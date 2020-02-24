package com.julienbirabent.fakeproductscatalogue.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import com.julienbirabent.fakeproductscatalogue.domain.Resource
import com.julienbirabent.fakeproductscatalogue.domain.common.GetOneByIdUseCase
import com.julienbirabent.fakeproductscatalogue.domain.wishlist.AddToWishListUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductDetailsViewModel @Inject constructor(
    private val getOneByIdUseCase: GetOneByIdUseCase,
    private val addToWishListUseCase: AddToWishListUseCase
) :
    ViewModel() {

    private val productId: MutableLiveData<String> = MutableLiveData()

    val product = Transformations.switchMap(productId) { id ->
        getOneByIdUseCase.execute(id).toLiveData()
    }

    fun setProductId(id: String) {
        productId.value = id
    }

    fun addToWishList(product: Product): LiveData<Resource<Product>> {
        return addToWishListUseCase.execute(product).toLiveData()
    }
}