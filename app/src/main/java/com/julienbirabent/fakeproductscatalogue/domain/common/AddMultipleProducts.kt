package com.julienbirabent.fakeproductscatalogue.domain.common

import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import com.julienbirabent.fakeproductscatalogue.data.repository.ProductRepository
import com.julienbirabent.fakeproductscatalogue.domain.Resource
import com.julienbirabent.fakeproductscatalogue.domain.UseCase
import com.julienbirabent.fakeproductscatalogue.rx.operator.ConverterToResourceTransformer
import io.reactivex.Observable
import javax.inject.Inject

class AddMultipleProducts @Inject constructor(private val repository: ProductRepository) :
    UseCase<List<Product>, Resource<List<Product>>>() {

    override fun buildUseCaseObservable(params: List<Product>): Observable<Resource<List<Product>>> {
        return Observable.fromIterable(params)
            .flatMapSingle { repository.addProduct(it) }
            .toList()
            .toObservable()
            .compose(ConverterToResourceTransformer())
    }
}