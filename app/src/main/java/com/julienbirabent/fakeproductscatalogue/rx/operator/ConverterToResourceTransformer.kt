package com.julienbirabent.fakeproductscatalogue.rx.operator

import com.julienbirabent.fakeproductscatalogue.domain.Resource
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer

class ConverterToResourceTransformer<T> : ObservableTransformer<T, Resource<T>> {

    override fun apply(upstream: Observable<T>): ObservableSource<Resource<T>> {
        return upstream.lift(ObservableResourceWrapperOperator<T>())
    }
}