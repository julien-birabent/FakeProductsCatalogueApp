package com.julienbirabent.fakeproductscatalogue.domain.wishlist

import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import com.julienbirabent.fakeproductscatalogue.data.repository.ProductRepository
import com.julienbirabent.fakeproductscatalogue.domain.Resource
import com.julienbirabent.fakeproductscatalogue.domain.UseCase
import com.julienbirabent.fakeproductscatalogue.rx.operator.ConverterToResourceTransformer
import io.reactivex.Observable
import javax.inject.Inject

class AddToWishListUseCase @Inject constructor(private val productRepository: ProductRepository) :
    UseCase<List<Product>, Resource<List<Product>>>() {

    override fun buildUseCaseObservable(params: List<Product>): Observable<Resource<List<Product>>> {
        return Observable.fromIterable(params)
            .flatMapSingle { productRepository.addToWishList(it) }
            .toList()
            .toObservable()
            .compose(ConverterToResourceTransformer())
    }
}