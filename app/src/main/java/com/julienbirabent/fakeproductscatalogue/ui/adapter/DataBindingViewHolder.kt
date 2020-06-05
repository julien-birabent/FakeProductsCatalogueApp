package com.julienbirabent.fakeproductscatalogue.ui.adapter
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView

class DataBindingViewHolder(val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(viewTypeHolder: ViewTypeHolder<*, *>) {
        with(viewTypeHolder) {
            binding.setVariable(BR.item, viewData)
            callback?.let { binding.setVariable(BR.callback, callback) }
            binding.executePendingBindings()
        }
    }
}