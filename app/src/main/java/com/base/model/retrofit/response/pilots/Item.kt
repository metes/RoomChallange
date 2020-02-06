package com.base.model.retrofit.response.pilots

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "point")
    val point: Int,
    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean = false
) {

    fun getPointString(): String {
        return "PTS: $point"
    }
}