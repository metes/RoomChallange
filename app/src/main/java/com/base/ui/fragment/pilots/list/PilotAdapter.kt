package com.base.ui.fragment.pilots.list


import android.view.LayoutInflater
import android.view.ViewGroup
import com.base.BR
import com.base.base.BaseAdapter
import com.base.base.BaseHolder
import com.base.databinding.ItemPilotBinding

open class ProductAdapter<T>(
    private val onItemClick: (T?) -> Unit,
    private val onFavorite: (T?) -> Unit
    ) : BaseAdapter<T, ItemPilotBinding, ProductHolder<T>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder<T> {
        val binding = ItemPilotBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductHolder(binding, onItemClick, onFavorite)
    }

}

class ProductHolder<T>(
    viewDataBinding: ItemPilotBinding,
    private val onItemClick: (T?) -> Unit,
    private val onFavorite: (T?) -> Unit
) : BaseHolder<T, ItemPilotBinding>(viewDataBinding) {

    override fun bindingVariable(): Int {
        return BR.item
    }

    override fun bind() {
        getRowBinding()?.let {
            it.btnFavorite.setOnClickListener { onFavorite(item) }
            it.containerItem.setOnClickListener { onItemClick(item) }
        }
    }
}

