package com.julienbirabent.fakeproductscatalogue.rx.operator

import com.julienbirabent.fakeproductscatalogue.domain.Resource
import io.reactivex.ObservableOperator
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class ObservableResourceWrapperOperator<T> : ObservableOperator<Resource<T>, T> {
    override fun apply(observer: Observer<in Resource<T>>): Observer<in T> {

        return object : Observer<T> {
            override fun onComplete() {
                observer.onComplete()
            }

            override fun onSubscribe(d: Disposable) {
                observer.onSubscribe(d)
                observer.onNext(Resource.loading(null))
            }

            override fun onNext(t: T) {
                observer.onNext(Resource.success(t))
            }

            override fun onError(e: Throwable) {
                observer.onNext(Resource.error(e, null))
            }
        }
    }


}