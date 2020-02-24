package com.julienbirabent.fakeproductscatalogue.domain.wishlist

import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import com.julienbirabent.fakeproductscatalogue.data.repository.product.WishListRepository
import com.julienbirabent.fakeproductscatalogue.domain.Resource
import com.julienbirabent.fakeproductscatalogue.domain.UseCase
import com.julienbirabent.fakeproductscatalogue.rx.operator.ConverterToResourceTransformer
import io.reactivex.Observable
import javax.inject.Inject

class AddToWishListUseCase @Inject constructor(private val wishListRepository: WishListRepository) :
    UseCase<Product, Resource<Product>>() {

    override fun buildUseCaseObservable(params: Product): Observable<Resource<Product>> {
        return wishListRepository.add(params)
            .toObservable()
            .compose(ConverterToResourceTransformer())
    }
}