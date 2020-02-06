package com.base.base

import androidx.annotation.NonNull
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Base Class for [RecyclerView.Adapter]
 */
abstract class BaseAdapter<M, DB : ViewDataBinding, VH : BaseHolder<M, DB>>: RecyclerView.Adapter<VH>() {

    var itemPosition = -1

    private var data: MutableList<M> = mutableListOf()

    override fun onBindViewHolder(@NonNull holder: VH, position: Int) {
        data?.get(position)?.let {
            holder.doBindings(it)
            itemPosition = position
            holder.bind()
        }
    }

    fun addData(newData: List<M>?) {
        if (newData == null) {
            return
        }
        if (data == null) {
            data = ArrayList()
        }
        data?.addAll(newData)
        notifyItemRangeInserted(itemCount, newData.size)
    }

    fun addData(newData: M?, position: Int) {
        if (newData == null) {
            return
        }
        if (data == null) {
            data = ArrayList()
        }
        data?.add(position, newData)
        notifyItemInserted(position)
    }

    fun removeData(position: Int) {
        data?.removeAt(position)
        notifyItemRemoved(position)
    }

    fun clearData() {
        data?.let {
            it.clear()
            notifyDataSetChanged()
        }
    }

    fun changeDataWithThis(newData: List<M>?) {
        clearData()
        addData(newData)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    fun getData(): MutableList<M>? {
        return data
    }
}