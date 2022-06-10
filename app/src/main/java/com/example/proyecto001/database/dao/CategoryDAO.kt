package com.example.proyecto001.database.dao

import androidx.room.*
import com.example.proyecto001.database.entities.Category
import com.example.proyecto001.database.entities.User

@Dao
interface CategoryDAO {

    @Query("SELECT * FROM category WHERE cateId = :id")
    suspend fun getCategoryById(id: Int): Category

    @Query("SELECT * FROM category WHERE cate_name LIKE :name LIMIT 1")
    suspend fun getCategoryByName(name: String): Category

    @Insert
    suspend fun insert(vararg categories: Category)

    @Update
    suspend fun update(category: Category)

    @Delete
    suspend fun delete(category: Category)
}