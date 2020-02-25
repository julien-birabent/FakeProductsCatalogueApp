package com.julienbirabent.fakeproductscatalogue.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import com.julienbirabent.fakeproductscatalogue.domain.Resource
import com.julienbirabent.fakeproductscatalogue.domain.common.GetOneByIdUseCase
import com.julienbirabent.fakeproductscatalogue.domain.wishlist.AddToWishListUseCase
import com.julienbirabent.fakeproductscatalogue.domain.wishlist.RemoveFromWishListUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductDetailsViewModel @Inject constructor(
    private val addToWishListUseCase: AddToWishListUseCase,
    private val removeFromWishListUseCase: RemoveFromWishListUseCase
) :
    ViewModel() {

    fun addToWishList(product: Product): LiveData<Resource<Product>> {
        return addToWishListUseCase.execute(product).toLiveData()
    }

    fun removeFromWishList(product: Product): LiveData<Resource<List<Product>>> {
        return removeFromWishListUseCase.execute(listOf(product)).toLiveData()
    }
}