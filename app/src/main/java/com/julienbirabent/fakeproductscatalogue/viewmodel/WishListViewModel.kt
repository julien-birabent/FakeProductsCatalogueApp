package com.julienbirabent.fakeproductscatalogue.viewmodel

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.julienbirabent.fakeproductscatalogue.domain.wishlist.GetWishListUseCase
import com.julienbirabent.fakeproductscatalogue.rx.firebase.None
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WishListViewModel @Inject constructor(getWishListUseCase: GetWishListUseCase) : ViewModel() {

    val wishList = getWishListUseCase.execute(None()).toLiveData()
    val isLoading = wishList.resourceLoadingLiveData()

    val totalCost = Transformations.map(wishList) { resource ->
        resource.data?.let {
            if (it.isNullOrEmpty()) "0" else {
                it.map { product -> product.price }.reduce { total, price -> total + price }
                    .toString()
            }
        }
    }
}