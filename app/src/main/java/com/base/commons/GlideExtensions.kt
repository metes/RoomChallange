package com.base.commons


import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.base.R
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import java.io.File
import java.net.URI


///**
// * String url, File,
// */
//@SuppressLint("CheckResult")
//fun ImageView.setImage(any: String, isCircle: Boolean = false) {
//    val glide = MyGlide.with(this)
//        .load(any)
//        .apply(getGlideRequestOptions())
//    if (isCircle) {
//        glide.apply(RequestOptions.circleCropTransform())
//    }
//    glide.into(this)
//}
//
//@SuppressLint("CheckResult")
//fun ImageView.setImage(any: File?, isCircle: Boolean = false) {
//    val glide = MyGlide.with(this)
//        .load(any)
//        .apply(getGlideRequestOptions())
//    if (isCircle) {
//        glide.apply(RequestOptions.circleCropTransform())
//    }
//    glide.into(this)
//}
//
//@SuppressLint("CheckResult")
//fun ImageView.setImage(any: Int?, isCircle: Boolean = false) {
//    val glide = KiaFanGlide.with(this)
//        .load(any)
//        .apply(getGlideRequestOptions())
//    if (isCircle) {
//        glide.apply(RequestOptions.circleCropTransform())
//    }
//    glide.into(this)
//}
//
//@SuppressLint("CheckResult")
//fun ImageView.setImage(any: URI, isCircle: Boolean = false) {
//    val glide = MyGlide.with(this)
//        .load(any)
//        .apply(getGlideRequestOptions())
//    if (isCircle) {
//        glide.apply(RequestOptions.circleCropTransform())
//    }
//    glide.into(this)
//}
//
///**
// * String url, File, URİ
// * success and error listeners
// */
//fun ImageView.setImageWithSuccessListener(
//    any: Any,
//    successAction: () -> Unit,
//    errorAction: (() -> Unit)? = null
//) {
//    KiaFanGlide.with(this)
//        .load(any)
//        .apply(getGlideRequestOptions())
//        .listener(object : RequestListener<Drawable> {
//            override fun onLoadFailed(
//                e: GlideException?,
//                model: Any?,
//                target: Target<Drawable>?,
//                isFirstResource: Boolean
//            ): Boolean {
//                errorAction?.let { it() }
//                return true
//            }
//
//            override fun onResourceReady(
//                resource: Drawable?,
//                model: Any?,
//                target: Target<Drawable>?,
//                dataSource: DataSource?,
//                isFirstResource: Boolean
//            ): Boolean {
//                successAction()
//                return false
//            }
//
//        })
//        .into(this)
//}