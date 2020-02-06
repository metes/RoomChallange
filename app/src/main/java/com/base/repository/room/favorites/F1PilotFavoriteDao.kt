package com.base.repository.room.favorites

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.base.model.wrapper.F1PilotFavoriteWraper


@Dao
interface F1PilotFavoriteDao {

    @Query("SELECT * FROM f1pilotfavoritewraper")
    suspend fun getAllPilotsFavorites(): List<F1PilotFavoriteWraper>


    @Query("UPDATE f1pilotfavoritewraper SET is_favorite =:isFavorite WHERE f1_pilot_id = :id")
    suspend fun updateFavoriteState(id: Int, isFavorite: Boolean)

    @Query("DELETE FROM f1pilotfavoritewraper")
    suspend fun deleteAllPilots()

    @Insert
    suspend fun insertAll(items : List<F1PilotFavoriteWraper>)
}