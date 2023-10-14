package ru.perelyginva.tobuy.data.model

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.perelyginva.tobuy.data.dao.ItemEntityDao

@Database(entities = [ItemEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemEntityDao(): ItemEntityDao
}