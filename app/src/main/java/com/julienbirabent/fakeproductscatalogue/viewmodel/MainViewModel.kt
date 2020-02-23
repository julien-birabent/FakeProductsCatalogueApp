package com.julienbirabent.fakeproductscatalogue.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import com.julienbirabent.fakeproductscatalogue.domain.Resource
import com.julienbirabent.fakeproductscatalogue.domain.common.AddMultipleObjects
import com.julienbirabent.fakeproductscatalogue.domain.common.GetAllUseCase
import com.julienbirabent.fakeproductscatalogue.rx.firebase.None
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainViewModel @Inject constructor(
    private val getAllUseCase: GetAllUseCase<Product>,
    private val addMultipleObjects: AddMultipleObjects<Product>
) :
    ViewModel() {

    val catalogue = getAllUseCase.execute(parameters = None()).toLiveData()

    fun uploadCatalogue(examples: List<Product>): LiveData<Resource<List<Product>>> {
        return addMultipleObjects.execute(examples).toLiveData()
    }

}