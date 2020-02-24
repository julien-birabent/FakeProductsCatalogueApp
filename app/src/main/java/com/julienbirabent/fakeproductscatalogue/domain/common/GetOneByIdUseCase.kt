package com.julienbirabent.fakeproductscatalogue.domain.common

import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import com.julienbirabent.fakeproductscatalogue.data.repository.ProductRepository
import com.julienbirabent.fakeproductscatalogue.domain.Resource
import com.julienbirabent.fakeproductscatalogue.domain.UseCase
import com.julienbirabent.fakeproductscatalogue.rx.operator.ConverterToResourceTransformer
import io.reactivex.Observable
import javax.inject.Inject

class GetOneByIdUseCase @Inject constructor(private val repository: ProductRepository) :
    UseCase<String, Resource<Product>>() {

    override fun buildUseCaseObservable(params: String): Observable<Resource<Product>> {
        return repository.getProduct(params).compose(ConverterToResourceTransformer())
    }

}