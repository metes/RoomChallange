package com.base.model.wrapper

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.base.model.retrofit.response.pilots.Item

@Entity
data class F1PilotFavoriteWraper(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "f1_pilot_id")
    var pilotId: Int,
    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean = false
) {


}