package com.julienbirabent.fakeproductscatalogue.binding

import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.julienbirabent.fakeproductscatalogue.data.entity.ImageResource
import com.julienbirabent.fakeproductscatalogue.ui.LayoutManagerFactory

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("android:visibility")
    fun showHide(view: View, show: Boolean) {
        view.visibility = if (show) View.VISIBLE else View.GONE
    }
}

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
fun setImageUriNullable(view: ImageView, imageUri: String?) {
    Glide.with(view).load(imageUri).into(view)
}


@BindingAdapter("android:src")
fun setImageUri(view: ImageView, imageUri: Uri?) {
    view.setImageURI(imageUri)
}

@BindingAdapter("android:src")
fun setImageDrawable(view: ImageView, drawable: Drawable?) {
    view.setImageDrawable(drawable)
}

@BindingAdapter("android:src")
fun setImageResource(view: ImageView, imageResource: ImageResource<*>) {
    when (imageResource.resource) {
        is String -> setImageUri(view, imageResource.resource)
        is Int -> setImageResourceResId(view, imageResource.resource)
        is Long -> setImageResourceResId(view, imageResource.resource.toInt())
    }
}

@BindingAdapter("android:src")
fun setImageResource(imageView: ImageView, resource: Int) {
    imageView.setImageResource(resource)
}

