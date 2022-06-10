package com.example.proyecto001.database.view

import android.app.Application
import androidx.lifecycle.*
import com.example.proyecto001.database.FinanzasDatabase
import com.example.proyecto001.database.entities.Item
import com.example.proyecto001.database.repository.ItemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewItem(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Item>>
    private val repository: ItemRepository

    init {
        val itemDAO = FinanzasDatabase.getInstance(application)!!.itemDAO()
        repository = ItemRepository(itemDAO)
        readAllData = repository.readAllData
    }

    fun insertItem(item: Item){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertItem(item)
        }
    }

    fun updateItem(item: Item){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateItem(item)
        }
    }

    fun deleteItem(item: Item){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteItem(item)
        }
    }
}

class ItemViewFactory(private val application: Application): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(ViewItem::class.java)) {
            return ViewItem(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}