package com.julienbirabent.fakeproductscatalogue.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import com.julienbirabent.fakeproductscatalogue.domain.Resource
import com.julienbirabent.fakeproductscatalogue.domain.common.AddMultipleProducts
import com.julienbirabent.fakeproductscatalogue.domain.common.GetAllProductUseCase
import com.julienbirabent.fakeproductscatalogue.rx.firebase.None
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainViewModel @Inject constructor(
    getAllProductUseCase: GetAllProductUseCase,
    private val addMultipleProducts: AddMultipleProducts
) :
    ViewModel() {

    val catalogue = getAllProductUseCase.execute(parameters = None()).toLiveData()

    val isLoading = catalogue.resourceLoadingLiveData()

    fun uploadCatalogue(examples: List<Product>): LiveData<Resource<List<Product>>> {
        return addMultipleProducts.execute(examples).toLiveData()
    }

}