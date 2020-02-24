package com.julienbirabent.fakeproductscatalogue.domain.wishlist

import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import com.julienbirabent.fakeproductscatalogue.data.repository.ProductRepository
import com.julienbirabent.fakeproductscatalogue.domain.Resource
import com.julienbirabent.fakeproductscatalogue.domain.UseCase
import com.julienbirabent.fakeproductscatalogue.rx.operator.ConverterToResourceTransformer
import io.reactivex.Observable
import javax.inject.Inject

class AddToWishListUseCase @Inject constructor(private val productRepository: ProductRepository) :
    UseCase<Product, Resource<Product>>() {

    override fun buildUseCaseObservable(params: Product): Observable<Resource<Product>> {
        return productRepository.addProduct(params)
            .toObservable()
            .compose(ConverterToResourceTransformer())
    }
}