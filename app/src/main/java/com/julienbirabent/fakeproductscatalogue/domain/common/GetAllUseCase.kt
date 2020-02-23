package com.julienbirabent.fakeproductscatalogue.domain.common

import com.julienbirabent.fakeproductscatalogue.data.entity.Model
import com.julienbirabent.fakeproductscatalogue.data.repository.SimpleRepository
import com.julienbirabent.fakeproductscatalogue.domain.Resource
import com.julienbirabent.fakeproductscatalogue.domain.UseCase
import com.julienbirabent.fakeproductscatalogue.rx.firebase.None
import com.julienbirabent.fakeproductscatalogue.rx.operator.ConverterToResourceTransformer
import io.reactivex.Observable
import javax.inject.Inject

class GetAllUseCase<Type : Model> @Inject constructor(private val repository: SimpleRepository<Type>) :
    UseCase<None, Resource<List<Type>>>() {

    override fun buildUseCaseObservable(params: None): Observable<Resource<List<Type>>> {
        return repository.getAll()
            .compose(ConverterToResourceTransformer())
    }
}