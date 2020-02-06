package com.base.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import com.base.R

open class CustomToolbar(context: Context, attrs: AttributeSet? = null) :
    FrameLayout(context, attrs) {

    var txtTitle: TextView
//    var txtSelection: TextView
//    var containerClickAndSelected: LinearLayout
//    var viewLine: View

    init {
        View.inflate(context, R.layout.custom_toolbar, this)
        txtTitle = findViewById(R.id.toolbar_title)
//        txtSelection = findViewById(R.id.txtSelection)
//        containerClickAndSelected = findViewById(R.id.containerClickAndSelected)
//        viewLine = findViewById(R.id.viewLine)
    }

//    fun setFunction(function: () -> Unit) {
//        containerClickAndSelected.setOnClickListener { function() }
//    }
//
//    fun showUnderLine(isShow: Boolean) {
//        viewLine.visibleIf(isShow)
//    }
//
//    fun editView(
//        title: String,
//        selection: String,
//        function: (() -> Unit)? = null) {
//
//        txtTitle.text = title
//        txtSelection.text = selection
//
//        function?.let {
//            it()
//        }
//    }


}