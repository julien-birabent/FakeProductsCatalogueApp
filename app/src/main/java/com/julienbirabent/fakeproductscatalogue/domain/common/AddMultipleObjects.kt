package com.julienbirabent.fakeproductscatalogue.domain.common

import com.julienbirabent.fakeproductscatalogue.data.entity.Model
import com.julienbirabent.fakeproductscatalogue.data.repository.SimpleRepository
import com.julienbirabent.fakeproductscatalogue.domain.Resource
import com.julienbirabent.fakeproductscatalogue.domain.UseCase
import com.julienbirabent.fakeproductscatalogue.rx.operator.ConverterToResourceTransformer
import io.reactivex.Observable
import javax.inject.Inject

class AddMultipleObjects<Type : Model> @Inject constructor(private val repository: SimpleRepository<Type>) :
    UseCase<List<Type>, Resource<List<Type>>>() {

    override fun buildUseCaseObservable(params: List<Type>): Observable<Resource<List<Type>>> {
        return Observable.fromIterable(params)
            .flatMapSingle { repository.add(it) }
            .toList()
            .toObservable()
            .compose(ConverterToResourceTransformer())
    }
}