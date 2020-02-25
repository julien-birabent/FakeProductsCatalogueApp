package com.julienbirabent.fakeproductscatalogue.ui.fragment

import android.widget.Button
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.julienbirabent.fakeproductscatalogue.R
import com.julienbirabent.fakeproductscatalogue.domain.Status

class ProductDetailsFromWishListFragment : ProductDetailsFragment() {

    override fun setupButtonAction(bottomActionButton: Button) {
        super.setupButtonAction(bottomActionButton)
        context?.let {
            bottomActionButton.apply {
                setButtonBackgroundColor(bottomActionButton, R.color.black)
                setOnClickListener {
                    viewModel.removeFromWishList(args.product)
                        .observe(viewLifecycleOwner, Observer {
                            if (it.status == Status.SUCCESS) {
                                findNavController().navigateUp()
                            }
                        })
                }
            }
            bottomActionButton.text = getString(R.string.action_remove_from_wish_list)
        }
    }
}