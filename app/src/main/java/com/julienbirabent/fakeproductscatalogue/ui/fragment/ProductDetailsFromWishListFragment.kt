package com.julienbirabent.fakeproductscatalogue.ui.fragment

import android.content.res.ColorStateList
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import com.julienbirabent.fakeproductscatalogue.R

class ProductDetailsFromWishListFragment : ProductDetailsFragment() {

    override fun setupButtonAction(bottomActionButton: Button) {
        super.setupButtonAction(bottomActionButton)
        context?.let {
            bottomActionButton.apply {
                backgroundTintList =
                    ColorStateList.valueOf(ContextCompat.getColor(it, R.color.black))
                setOnClickListener { findNavController().navigateUp() }
            }
        }
    }
}