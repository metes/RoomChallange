package com.base.commons

import android.content.Context
import android.graphics.Bitmap
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.Excludes
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.DecodeFormat.PREFER_ARGB_8888
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.signature.ObjectKey
import okhttp3.OkHttpClient
import java.io.InputStream
import java.util.concurrent.TimeUnit

//const val GLIDE_DEFAULT_TIMEOUT_SECONDS = 10L
//
//@GlideModule(glideName = "MyAppGlide")
//@Excludes(value = [OkHttpLibraryGlideModule::class])
//class MyAppGlideModule : AppGlideModule() {
//
//    /**
//     * Registers necessary components for Glide
//     *
//     * @param context  represents an instance of [Context]
//     * @param glide    represents an instance of [Glide]
//     * @param registry represents an instance of [Registry]
//     */
//    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
//        val client = OkHttpClient.Builder()
//            .readTimeout(GLIDE_DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
//            .connectTimeout(GLIDE_DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
//            .build()
//
//        val factory = OkHttpUrlLoader.Factory(client)
//
//        glide.registry.replace(GlideUrl::class.java, InputStream::class.java, factory)
//    }
//
//
//    /**
//     * Applies specific options to Glide
//     *
//     * @param context represents an instance of [Context]
//     * @param builder represents an instance of [GlideBuilder]
//     */
//    override fun applyOptions(context: Context, builder: GlideBuilder) {
//        val memoryCacheSizeBytes = 1024 * 1024 * 300 // 300mb cache
//        builder.setMemoryCache(LruResourceCache(memoryCacheSizeBytes.toLong()))
//        builder.setDiskCache(InternalCacheDiskCacheFactory(context, memoryCacheSizeBytes.toLong()))
//        builder.setDefaultRequestOptions(requestOptions())
//    }
//
//    /**
//     * A default [RequestOptions] to customize Glide
//     *
//     * @return an instance of [RequestOptions]
//     */
//    private fun requestOptions(): RequestOptions {
//        return RequestOptions()
//            .signature(
//                ObjectKey(
//                    System.currentTimeMillis() / (168 * 60 * 60 * 1000)
//                )
//            ) // 1 week cache
//            .centerCrop()
//            .dontAnimate()
//            .override(Target.SIZE_ORIGINAL)
//            .encodeFormat(Bitmap.CompressFormat.PNG)
//            .encodeQuality(100)
//            .diskCacheStrategy(DiskCacheStrategy.ALL)
//            .format(PREFER_ARGB_8888)
//            .skipMemoryCache(true)
//    }
//}
