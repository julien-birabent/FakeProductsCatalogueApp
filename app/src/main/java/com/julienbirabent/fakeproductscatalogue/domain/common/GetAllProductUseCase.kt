package com.julienbirabent.fakeproductscatalogue.domain.common

import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import com.julienbirabent.fakeproductscatalogue.data.repository.ProductRepository
import com.julienbirabent.fakeproductscatalogue.domain.Resource
import com.julienbirabent.fakeproductscatalogue.domain.UseCase
import com.julienbirabent.fakeproductscatalogue.rx.firebase.None
import com.julienbirabent.fakeproductscatalogue.rx.operator.ConverterToResourceTransformer
import io.reactivex.Observable
import javax.inject.Inject

class GetAllProductUseCase@Inject constructor(private val repository: ProductRepository) :
    UseCase<None, Resource<List<Product>>>() {

    override fun buildUseCaseObservable(params: None): Observable<Resource<List<Product>>> {
        return repository.getAllProducts()
            .compose(ConverterToResourceTransformer())
    }
}