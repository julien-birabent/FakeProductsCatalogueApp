package com.julienbirabent.fakeproductscatalogue.ui.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class OmniAdapter :
    RecyclerView.Adapter<OmniDataBindingViewHolder>() {

    private var items: MutableList<ViewTypeHolder<*, *>> = mutableListOf()

    private fun setItems(listItems: List<ViewTypeHolder<*, *>>) {
        this.items = listItems.toMutableList()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    fun updateList(newList: List<ViewTypeHolder<*, *>>) {
        val diffUtil = getDiffUtilCallback(this.items, newList)
        if (diffUtil != null) {
            val result = DiffUtil.calculateDiff(diffUtil)
            result.dispatchUpdatesTo(this)
            this.items.clear()
            this.items.addAll(newList)
        } else {
            setItems(newList)
        }
    }

    private fun getDiffUtilCallback(
        oldList: List<ViewTypeHolder<*, *>>,
        newList: List<ViewTypeHolder<*, *>>
    ): BaseDiffCallback<ViewTypeHolder<*, *>>? {
        return BaseDiffCallback(oldList, newList, areItemsTheSame = { oldItem, newItem ->
            oldItem == newItem
        }, areContentTheSame = { oldItem, newItem ->
            oldItem == newItem
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OmniDataBindingViewHolder {
        return getViewHolder(parent, viewType)
    }

    private fun getViewHolder(
        parent: ViewGroup,
        layoutResId: Int
    ): OmniDataBindingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, layoutResId, parent, false)
        return OmniDataBindingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OmniDataBindingViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].layoutResId
    }
}