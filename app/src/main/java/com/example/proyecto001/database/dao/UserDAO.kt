package com.example.proyecto001.database.dao

import androidx.room.*
import com.example.proyecto001.database.entities.User

@Dao
interface UserDAO {
    @Query("SELECT * FROM users")
    suspend fun getAll(): List<User>

    @Query("SELECT * FROM users WHERE userId = :id")
    suspend fun getUserById(id: Int): User

    @Query("SELECT * FROM users WHERE user_name LIKE :name or user_mail LIKE :mail LIMIT 1")
    suspend fun findByNameOrMail(name: String, mail: String): User

    @Insert
    suspend fun insert(vararg users: User)

    @Update
    suspend fun update(user: User)

    @Delete
    suspend fun delete(user: User)
}