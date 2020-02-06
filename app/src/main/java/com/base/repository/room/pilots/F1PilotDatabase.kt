package com.base.repository.room.pilots

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.base.model.retrofit.response.pilots.Item

@Database(entities = [Item::class], version = 1)
abstract class F1PilotDatabase : RoomDatabase() {

    abstract fun f1PilotDao(): F1PilotDao

    companion object {
        @Volatile
        private var instance: F1PilotDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
            instance
                ?: buildDatabase(
                    context
                ).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            F1PilotDatabase::class.java,
            "f1PilotDatabase"
        ).build()
    }

}
