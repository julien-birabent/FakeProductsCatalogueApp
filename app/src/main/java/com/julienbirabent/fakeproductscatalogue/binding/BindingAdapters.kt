package com.julienbirabent.fakeproductscatalogue.binding

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.julienbirabent.fakeproductscatalogue.data.entity.ImageResource
import com.julienbirabent.fakeproductscatalogue.data.entity.product.ColorResource
import com.julienbirabent.fakeproductscatalogue.ui.LayoutManagerFactory

@BindingAdapter(
    value = ["app:setAdapter", "app:setOrientation", "app:disableAnimation"],
    requireAll = false
)
fun bindRecyclerViewAdapter(
    recyclerView: RecyclerView,
    adapter: RecyclerView.Adapter<*>,
    orientation: Int = RecyclerView.HORIZONTAL,
    disableAnimation: Boolean = false
) {
    recyclerView.apply {
        setHasFixedSize(false)
        layoutManager = LayoutManagerFactory.createLinearLayoutManager(this, orientation)
        if (disableAnimation) itemAnimator = null else DefaultItemAnimator()
        this.adapter = adapter
    }
}

@BindingAdapter("android:src")
fun setImageResourceResId(imageView: ImageView, resource: Int) {
    imageView.setImageResource(resource)
}

@BindingAdapter("android:src")
fun setImageUri(view: ImageView, imageUri: String) {
    Glide.with(view).load(imageUri).into(view)
}

@BindingAdapter("android:src")
fun setImageResource(view: ImageView, imageResource: ImageResource<*>) {
    view.setImageResourceExt(imageResource)
}

fun ImageView.setImageResourceExt(imageResource: ImageResource<*>) {
    when (imageResource.resource) {
        is String -> setImageUri(this, imageResource.resource)
        is Int -> setImageResourceResId(this, imageResource.resource)
        is Long -> setImageResourceResId(this, imageResource.resource.toInt())
    }
}

@BindingAdapter("android:plainColor")
fun setPlainColorImageResource(imageView: CardView, colorResource: ColorResource<*>?) {
    imageView.setPlainColorImageResourceExt(colorResource)
}

fun CardView.setPlainColorImageResourceExt(imageResource: ColorResource<*>?) {
    imageResource?.let {
        when (it.value) {
            is String -> this.setCardBackgroundColor(Color.parseColor(it.value))
        }
    }
}

@BindingAdapter("android:visibility")
fun setVisibility(view: View, value: Boolean) {
    view.visibility = if (value) View.VISIBLE else View.GONE
}

