package ru.perelyginva.tobuy.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.perelyginva.tobuy.data.database.AppDatabase
import ru.perelyginva.tobuy.data.model.ItemEntity
import ru.perelyginva.tobuy.presentation.repository.ToByRepository

class ToByViewModel : ViewModel() {

    val itemEntitiesLiveData = MutableLiveData<List<ItemEntity>>()

    private lateinit var repository: ToByRepository

    fun init(appDatabase: AppDatabase) {
        repository = ToByRepository(appDatabase)

        val items = repository.getAllItems()
        itemEntitiesLiveData.postValue(items)
    }

    fun insertItem(itemEntity: ItemEntity) {
        repository.insertItem(itemEntity)

    }

    fun deleteItem(itemEntity: ItemEntity) {
        repository.deleteItem(itemEntity)
    }
}