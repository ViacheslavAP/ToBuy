package ru.perelyginva.tobuy.presentation.repository

import ru.perelyginva.tobuy.data.database.AppDatabase
import ru.perelyginva.tobuy.data.model.ItemEntity

//будем взаимодействовать с базой данных
class ToByRepository(
    private val appDatabase: AppDatabase,
) {

   suspend fun insertItem(itemEntity: ItemEntity) {
        appDatabase.itemEntityDao().insert(itemEntity)

    }

   suspend fun deleteItem(itemEntity: ItemEntity) {
        appDatabase.itemEntityDao().delete(itemEntity)
    }


   suspend fun getAllItems(): List<ItemEntity> {
        return appDatabase.itemEntityDao().getAllEntities()
    }
}