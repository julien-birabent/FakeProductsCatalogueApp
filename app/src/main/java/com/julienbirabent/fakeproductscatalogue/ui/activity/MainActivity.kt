package com.julienbirabent.fakeproductscatalogue.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.julienbirabent.fakeproductscatalogue.BR
import com.julienbirabent.fakeproductscatalogue.R
import com.julienbirabent.fakeproductscatalogue.data.RandomProductsGenerator
import com.julienbirabent.fakeproductscatalogue.databinding.ActivityMainBinding
import com.julienbirabent.fakeproductscatalogue.domain.Status
import com.julienbirabent.fakeproductscatalogue.preferences.AppPreferences
import com.julienbirabent.fakeproductscatalogue.ui.base.BaseActivity
import com.julienbirabent.fakeproductscatalogue.viewmodel.MainViewModel
import javax.inject.Inject


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override var layoutId: Int = R.layout.activity_main
    override var viewModelClass: Class<MainViewModel> = MainViewModel::class.java
    override var viewModelBindingVariable: Int = BR.viewModel

    @Inject
    lateinit var appPreferences: AppPreferences

    @Inject
    lateinit var randomProductsGenerator: RandomProductsGenerator

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        viewModel.catalogue.observe(this, Observer { resource ->
            if (resource.status != Status.LOADING && resource.data.isNullOrEmpty()) {
                Log.d(MainActivity::class.simpleName, "Catalogue is being uploaded.")
                viewModel.uploadCatalogue(randomProductsGenerator.generateRandomProductList(10))
                    .observe(this, Observer {
                        if (it.status == Status.SUCCESS) {
                            Log.d(MainActivity::class.simpleName, "Catalogue has been uploaded.")
                        }
                    })
            } else {
                Log.d(MainActivity::class.simpleName, "Catalogue has already been uploaded.")
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}
