package com.base.ui.fragment.pilots.detail

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.base.base.BaseViewModel
import com.base.model.retrofit.response.details.F1PilotDetails
import com.base.repository.network.APIClient
import kotlinx.coroutines.launch


class PilotDetailVM(val app: Application, private val client: APIClient) : BaseViewModel(app, client) {

    val detailsLD: LiveData<F1PilotDetails> = MutableLiveData()


    fun getDetails(id: Int) {
        sendRequest({ client.getF1PilotDetail(id) }, { details ->
            viewModelScope.launch {
                (detailsLD as MutableLiveData).postValue(details)
            }
        })
    }


}

