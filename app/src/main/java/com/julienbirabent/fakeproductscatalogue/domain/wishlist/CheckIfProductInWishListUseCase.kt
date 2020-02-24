package com.julienbirabent.fakeproductscatalogue.domain.wishlist

import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import com.julienbirabent.fakeproductscatalogue.data.repository.product.ProductRepositoryImpl
import com.julienbirabent.fakeproductscatalogue.domain.UseCase
import io.reactivex.Observable
import javax.inject.Inject

class CheckIfProductInWishListUseCase @Inject constructor(
    private val productRepository: ProductRepositoryImpl
) : UseCase<Product, Boolean>() {
    override fun buildUseCaseObservable(params: Product): Observable<Boolean> {
        return productRepository.getWishList().contains(params).toObservable()
    }
}