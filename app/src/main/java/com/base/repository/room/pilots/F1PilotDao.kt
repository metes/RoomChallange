package com.base.repository.room.pilots

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.base.model.retrofit.response.pilots.Item


@Dao
interface F1PilotDao {
    @Insert
    suspend fun insertAll(items : List<Item>)

    @Query("SELECT * FROM item")
    suspend fun getAllPilots(): List<Item>

    @Query("SELECT * FROM item WHERE id = :id")
    suspend fun getPilot(id: Int) : Item

    @Query("DELETE FROM item")
    suspend fun deleteAllPilots()

    @Query("SELECT * FROM item ORDER BY point DESC")
    fun loadAllPilots(): LiveData<List<Item>>

}