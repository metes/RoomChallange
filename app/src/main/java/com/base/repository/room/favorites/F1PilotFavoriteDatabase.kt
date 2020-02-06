package com.base.repository.room.favorites

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.base.model.wrapper.F1PilotFavoriteWraper

@Database(entities = [F1PilotFavoriteWraper::class], version = 1)
abstract class F1PilotFavoriteDatabase : RoomDatabase() {

    abstract fun f1PilotFavoriteDao(): F1PilotFavoriteDao

    companion object {
        @Volatile
        private var instance: F1PilotFavoriteDatabase? = null
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
            F1PilotFavoriteDatabase::class.java,
            "f1PilotFavoriteDatabase"
        ).build()
    }

}
