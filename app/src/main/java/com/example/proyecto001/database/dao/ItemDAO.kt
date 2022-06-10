package com.example.proyecto001.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.proyecto001.database.entities.Item
import com.example.proyecto001.database.entities.User

@Dao
interface ItemDAO {
    @Query("SELECT * FROM items")
    fun getAll(): LiveData<List<Item>>

    @Query("SELECT * FROM items WHERE itemCate LIKE :category LIMIT 1")
    fun getItemsByCategory(category: String): Item

    @Insert
    suspend fun insertAll(vararg items: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)
}