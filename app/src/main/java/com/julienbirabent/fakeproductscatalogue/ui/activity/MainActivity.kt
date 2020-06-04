package com.julienbirabent.fakeproductscatalogue.ui.activity

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.julienbirabent.fakeproductscatalogue.BR
import com.julienbirabent.fakeproductscatalogue.R
import com.julienbirabent.fakeproductscatalogue.data.RandomProductsGenerator
import com.julienbirabent.fakeproductscatalogue.databinding.ActivityMainBinding
import com.julienbirabent.fakeproductscatalogue.ui.base.BaseActivity
import com.julienbirabent.fakeproductscatalogue.viewmodel.MainViewModel
import javax.inject.Inject


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override var layoutId: Int = R.layout.activity_main
    override var viewModelClass: Class<MainViewModel> = MainViewModel::class.java
    override var viewModelBindingVariable: Int = BR.viewModel

    @Inject
    lateinit var randomProductsGenerator: RandomProductsGenerator

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
