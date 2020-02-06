package com.base.commons

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.base.R


@BindingAdapter("imageResource")
fun setImageResource(view: ImageView, resId: Int?) {
    val resourceId = if (resId == null || resId == 0) R.drawable.ic_error_24dp else resId
    view.setImageResource(resourceId)
}
