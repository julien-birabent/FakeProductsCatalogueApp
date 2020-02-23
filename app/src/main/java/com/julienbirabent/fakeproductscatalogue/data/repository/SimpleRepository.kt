package com.julienbirabent.fakeproductscatalogue.data.repository

import com.julienbirabent.fakeproductscatalogue.data.entity.Model
import io.reactivex.Observable
import io.reactivex.Single

interface SimpleRepository<ModelType : Model> {

    fun add(model : ModelType) : Single<ModelType>

    fun getAll() : Observable<List<ModelType>>

    fun get(id : String) : Observable<ModelType>
}