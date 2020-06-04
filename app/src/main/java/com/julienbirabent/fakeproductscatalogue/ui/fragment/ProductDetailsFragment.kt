package com.julienbirabent.fakeproductscatalogue.ui.fragment

import android.annotation.SuppressLint
import android.text.method.ScrollingMovementMethod
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.julienbirabent.fakeproductscatalogue.BR
import com.julienbirabent.fakeproductscatalogue.R
import com.julienbirabent.fakeproductscatalogue.binding.setImageResourceExt
import com.julienbirabent.fakeproductscatalogue.data.entity.product.ColorResource
import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import com.julienbirabent.fakeproductscatalogue.databinding.FragmentProductDetailsBinding
import com.julienbirabent.fakeproductscatalogue.ui.adapter.ItemSelectionCallback
import com.julienbirabent.fakeproductscatalogue.ui.adapter.OmniAdapter
import com.julienbirabent.fakeproductscatalogue.ui.adapter.ViewTypeHolder
import com.julienbirabent.fakeproductscatalogue.ui.base.BaseFragment
import com.julienbirabent.fakeproductscatalogue.viewmodel.ProductDetailsViewModel

open class ProductDetailsFragment :
    BaseFragment<FragmentProductDetailsBinding, ProductDetailsViewModel>() {
    override var viewModelBindingVariable: Int = BR.viewModel
    override var layoutResId: Int = R.layout.fragment_product_details

    override fun provideViewModel(): ProductDetailsViewModel {
        return ViewModelProvider(this, viewModelFactory).get(ProductDetailsViewModel::class.java)
    }

    private val colorAdapter = OmniAdapter()
    protected val args by navArgs<ProductDetailsFragmentArgs>()

    override fun setDataBindingVariables(binding: ViewDataBinding) {
        super.setDataBindingVariables(binding)
        layoutBinding.setVariable(BR.colorAdapter, colorAdapter)
    }

    @SuppressLint("SetTextI18n")
    override fun onStart() {
        super.onStart()

        displayNavigateUpButton()
        actionBarTitle(args.product.title)
        setupUiWithProduct(args.product)
    }


    private fun setupUiWithProduct(product: Product) {
        updateColorList(product)
        layoutBinding.apply {
            textPrice.text =
                String.format(getString(R.string.can_dollar_sign), product.price.toString())
            product.imageResource?.let { imageResource ->
                imageProduct.setImageResourceExt(
                    imageResource
                )
            }
            textDescription.text = product.description
            textDescription.movementMethod = ScrollingMovementMethod()

            textDimensions.text =
                "H : ${product.dimensions.height}\nW : ${product.dimensions.width}\nD : ${product.dimensions.depth}"
        }
    }

    private fun updateColorList(it: Product) {
        colorAdapter.updateList(it.colors.map { colorResource ->
            createItemViewTypeHolder(
                colorResource
            )
        })
    }

    private fun createItemViewTypeHolder(item: ColorResource<*>): ViewTypeHolder<ColorResource<*>, ItemSelectionCallback<*>> {
        return ViewTypeHolder(
            viewData = item,
            layoutResId = R.layout.item_image_thumbnail
        )
    }
}