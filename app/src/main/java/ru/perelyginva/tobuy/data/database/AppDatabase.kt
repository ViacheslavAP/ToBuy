package ru.perelyginva.tobuy.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.perelyginva.tobuy.data.dao.ItemEntityDao
import ru.perelyginva.tobuy.data.model.ItemEntity

@Database(entities = [ItemEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private var appDatabase: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if (appDatabase != null) {
                return appDatabase!!
            }
            appDatabase = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "to_by_database"
            ).build()
            return appDatabase!!
        }
    }

    abstract fun itemEntityDao(): ItemEntityDao
}