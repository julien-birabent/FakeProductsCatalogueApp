package com.julienbirabent.fakeproductscatalogue.domain.common

import com.julienbirabent.fakeproductscatalogue.data.entity.Model
import com.julienbirabent.fakeproductscatalogue.data.entity.UniqueModel
import com.julienbirabent.fakeproductscatalogue.data.repository.SimpleRepository
import com.julienbirabent.fakeproductscatalogue.domain.Resource
import com.julienbirabent.fakeproductscatalogue.domain.UseCase
import com.julienbirabent.fakeproductscatalogue.rx.operator.ConverterToResourceTransformer
import io.reactivex.Observable
import javax.inject.Inject

class DeleteUseCase<ModelType : Model> @Inject constructor(
    private val repository: SimpleRepository<ModelType>
) : UseCase<List<ModelType>, Resource<List<ModelType>>>() {

    override fun buildUseCaseObservable(params: List<ModelType>): Observable<Resource<List<ModelType>>> {
        return Observable.fromIterable(params)
            .flatMapSingle { repository.delete(it) }
            .toList()
            .toObservable()
            .compose(ConverterToResourceTransformer())

    }

}