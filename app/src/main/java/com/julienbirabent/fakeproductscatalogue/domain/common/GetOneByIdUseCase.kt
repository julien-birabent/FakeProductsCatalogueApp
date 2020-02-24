package com.julienbirabent.fakeproductscatalogue.domain.common

import com.julienbirabent.fakeproductscatalogue.data.entity.Model
import com.julienbirabent.fakeproductscatalogue.data.repository.SimpleRepository
import com.julienbirabent.fakeproductscatalogue.domain.Resource
import com.julienbirabent.fakeproductscatalogue.domain.UseCase
import com.julienbirabent.fakeproductscatalogue.rx.operator.ConverterToResourceTransformer
import io.reactivex.Observable
import javax.inject.Inject

class GetOneByIdUseCase<Type : Model> @Inject constructor(private val repository: SimpleRepository<Type>) :
    UseCase<String, Resource<Type>>() {

    override fun buildUseCaseObservable(params: String): Observable<Resource<Type>> {
        return repository.get(params).compose(ConverterToResourceTransformer())
    }

}