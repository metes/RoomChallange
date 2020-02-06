package com.base.commons

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class SharedPrefHelper(private val context: Context) {

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences("reasonkey", Context.MODE_PRIVATE)
    }


    /**
     * Helps save String data
     */
    private fun putStringData(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    /**
     * Helps get String data
     */
    private fun getStringData(key: String, defVal: String?): String? {
        return sharedPreferences.getString(key, defVal)
    }

    /**
     * Add List of object data with given key to Shared preferences
     */
    private fun <T> addListData(key: String, list: List<T>?) {
        if (list == null) {
            throw RuntimeException("Data can not be null")
        }
        putStringData(key, Gson().toJsonTree(list).asJsonArray.toString())
    }


    /**
     * Retrieve list of objects with given key from Shared preferences
     */
    private fun <T> retrieveListData(key: String, tt: TypeToken<List<T>>): List<T>? {
        val json = getStringData(key, null)
        return if (sharedPreferences.contains(key)) {
            if (json == null) null else Gson().fromJson<List<T>>(json, tt.type)
        } else {
            null
        }
    }

}
