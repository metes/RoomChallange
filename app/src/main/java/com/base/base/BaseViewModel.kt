package com.base.base

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.base.R
import com.base.commons.SingleLiveEvent
import com.base.repository.network.APIClient
import com.base.repository.network.Repository.handleRequest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

open class BaseViewModel(private val myApp: Application, private val apiClient: APIClient) :
    AndroidViewModel(myApp) {

    /**
     *  Hata olmasi durumunda UI'da kullanmak uzere tanimlanan SingleLiveEvent
     */
    val networkErrorDetection by lazy { SingleLiveEvent<String>() }
    /**
     *  Request oncesinde true sonrasinda false olan SingleLiveEvent
     */
    val loadingDetection by lazy { SingleLiveEvent<Boolean>() }

    /**
     *  Retrofit'den donen hatalar burada yakalaniyor. Exception messaji kullaniciya gosterebilir veya ozellestirilebilir
     */
    private fun throwError(errorMessage: String?) {
        val message = when {
            errorMessage?.startsWith("HTTP 400") == true -> myApp.getString(R.string.error_message_401)
            errorMessage?.startsWith("HTTP 401") == true -> myApp.getString(R.string.error_message_401)
            errorMessage?.startsWith("HTTP 404") == true -> myApp.getString(R.string.error_message_404)
            errorMessage?.startsWith("HTTP 500") == true -> myApp.getString(R.string.error_message_500)
            else -> if (errorMessage.isNullOrBlank()) myApp.getString(R.string.error_message_main) else errorMessage
        }
        networkErrorDetection.postValue(message)
    }


    fun <T : Any> sendRequest(
        client: suspend () -> T,
        function: ((T?) -> Unit)? = null
    ) {
        viewModelScope.launch {
            loadingDetection.postValue(true)
            val result = handleRequest(client)
            when {
                result.isSuccess -> {
                    val responseData = result.getOrNull()
                    function?.let { it(responseData) }
                }
                else -> throwError(result.exceptionOrNull()?.message)
            }
            loadingDetection.postValue(false)
        }
    }




}