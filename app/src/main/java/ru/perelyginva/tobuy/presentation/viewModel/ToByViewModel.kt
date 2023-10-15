package ru.perelyginva.tobuy.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.perelyginva.tobuy.data.database.AppDatabase
import ru.perelyginva.tobuy.data.model.ItemEntity
import ru.perelyginva.tobuy.presentation.repository.ToByRepository

class ToByViewModel : ViewModel() {

    val itemEntitiesLiveData = MutableLiveData<List<ItemEntity>>()

    private lateinit var repository: ToByRepository

    fun init(appDatabase: AppDatabase) {
        repository = ToByRepository(appDatabase)

       viewModelScope.launch(Dispatchers.IO) {
           val items = repository.getAllItems()
           itemEntitiesLiveData.postValue(items)
       }
    }

    suspend fun insertItem(itemEntity: ItemEntity) {
        viewModelScope.launch {
            repository.insertItem(itemEntity)
        }


    }

    suspend fun deleteItem(itemEntity: ItemEntity) {
        viewModelScope.launch {
            repository.deleteItem(itemEntity)
        }

    }
}