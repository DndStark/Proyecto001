package com.example.proyecto001.database.repository

import com.example.proyecto001.database.entities.User

interface UserRepository {
    suspend fun getAll(): List<User>

    suspend fun getUserById(id: Int): User?

    suspend fun insertUser(user: User)

    suspend fun deleteUser(user: User)
}