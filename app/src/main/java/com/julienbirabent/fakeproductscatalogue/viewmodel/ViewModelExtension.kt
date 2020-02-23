package com.julienbirabent.fakeproductscatalogue.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.Transformations
import com.julienbirabent.fakeproductscatalogue.domain.Resource
import com.julienbirabent.fakeproductscatalogue.domain.Status
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable

fun isResourceLoading(resource: Resource<*>): Boolean {
    return resource.status == Status.LOADING
}

fun <T : LiveData<Resource<G>>, G : Any> T.resourceLoadingLiveData(): LiveData<Boolean> {
    return Transformations.map(this, ::isResourceLoading)
}

fun <T> Observable<T>.toLiveData(): LiveData<T> {
    return LiveDataReactiveStreams.fromPublisher(this.toFlowable(BackpressureStrategy.DROP))
}