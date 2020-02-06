package com.base.ui.fragment.pilots.list

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.base.base.BaseViewModel
import com.base.model.retrofit.response.pilots.Item
import com.base.repository.network.APIClient
import com.base.repository.room.favorites.F1PilotFavoriteDao
import com.base.repository.room.favorites.F1PilotFavoriteDatabase
import com.base.repository.room.pilots.F1PilotDao
import com.base.repository.room.pilots.F1PilotDatabase
import kotlinx.coroutines.launch


class PilotVM(val app: Application, private val client: APIClient) : BaseViewModel(app, client) {

    private val f1PilotDao: F1PilotDao by lazy { F1PilotDatabase(
        app
    ).f1PilotDao() }
    private val f1PilotFavoriteDao: F1PilotFavoriteDao by lazy { F1PilotFavoriteDatabase(
        app
    ).f1PilotFavoriteDao() }

    val allPilptsLD: LiveData<List<Item>> = f1PilotDao.loadAllPilots()

    init {
        fetchSongs()
    }

    fun fetchSongs() {
        sendRequest({ client.getF1PilotList() }, { newList ->
            viewModelScope.launch {
                newList?.let {
                    f1PilotDao.deleteAllPilots()
                    val favoriteList = f1PilotFavoriteDao.getAllPilotsFavorites()
                    newList.items.forEach { pilot ->
                        val isfavorite = favoriteList.firstOrNull { it.pilotId == pilot.id }?.isFavorite
                        if (isfavorite != null) {
                            pilot.isFavorite = isfavorite
                        }
                    }
                    f1PilotDao.insertAll(it.items)

                }
            }
        })
    }

    fun updateFavorite(id: Int, isFavorite: Boolean) {
        viewModelScope.launch {
            f1PilotFavoriteDao.updateFavoriteState(id, isFavorite)
            fetchSongs()
        }
    }


}

