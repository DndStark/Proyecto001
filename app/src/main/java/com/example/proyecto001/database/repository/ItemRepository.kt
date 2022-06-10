package com.example.proyecto001.database.repository

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.example.proyecto001.database.dao.ItemDAO
import com.example.proyecto001.database.entities.Item

class ItemRepository(private val itemDAO: ItemDAO) {

    val readAllData: LiveData<List<Item>> = itemDAO.getAll()

    suspend fun insertItem(item: Item){
        itemDAO.insertAll(item)
    }

    suspend fun updateItem(item: Item){
        itemDAO.update(item)
    }

    suspend fun deleteItem(item: Item){
        itemDAO.delete(item)
    }

}