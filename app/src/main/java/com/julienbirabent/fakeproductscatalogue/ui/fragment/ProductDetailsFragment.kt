package com.julienbirabent.fakeproductscatalogue.ui.fragment

import android.annotation.SuppressLint
import android.text.method.ScrollingMovementMethod
import android.util.Log
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.julienbirabent.fakeproductscatalogue.BR
import com.julienbirabent.fakeproductscatalogue.R
import com.julienbirabent.fakeproductscatalogue.binding.setImageResourceExt
import com.julienbirabent.fakeproductscatalogue.data.entity.product.ColorResource
import com.julienbirabent.fakeproductscatalogue.data.entity.product.Product
import com.julienbirabent.fakeproductscatalogue.databinding.FragmentProductDetailsBinding
import com.julienbirabent.fakeproductscatalogue.domain.Status
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
    private val args by navArgs<ProductDetailsFragmentArgs>()

    override fun setDataBindingVariables(binding: ViewDataBinding) {
        super.setDataBindingVariables(binding)
        layoutBinding.setVariable(BR.colorAdapter, colorAdapter)
    }

    @SuppressLint("SetTextI18n")
    override fun onStart() {
        super.onStart()

        displayNavigateUpButton()
        actionBarTitle(args.product.title)

        viewModel.setProductId(args.product.uid)
        viewModel.product.observe(this, Observer { resource ->
            resource.data?.let {
                updateColorList(it)
                setupUiWithProduct(it)
            }
        })
        setupButtonAction()
    }

    protected open fun setupButtonAction() {
        setAddToWishListAction()
    }

    private fun setAddToWishListAction() {
        layoutBinding.buttonAddWishList.setOnClickListener {
            viewModel.addToWishList(args.product).observe(this,
                Observer {
                    if (it.status == Status.SUCCESS) {
                        Log.d(
                            ProductDetailsFragment::class.java.simpleName,
                            "Product added to wishlist"
                        )
                        findNavController().navigateUp()
                    }
                })
        }
    }

    private fun setupUiWithProduct(it: Product) {
        layoutBinding.apply {
            textPrice.text =
                String.format(getString(R.string.can_dollar_sign), it.price.toString())
            it.imageResource?.let { imageResource ->
                imageProduct.setImageResourceExt(
                    imageResource
                )
            }
            textDescription.text = it.description
            textDescription.movementMethod = ScrollingMovementMethod()

            textDimensions.text =
                "H : ${it.dimensions.height}\nW : ${it.dimensions.width}\nD : ${it.dimensions.depth}"
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