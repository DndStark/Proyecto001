package com.example.proyecto001.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "users")
data class User (
    @PrimaryKey(autoGenerate = true) val userId: Int,
    @ColumnInfo(name = "user_name") val userName: String?,
    @ColumnInfo(name = "user_mail") val userMail: String?,
    @ColumnInfo(name = "user_gender") val userGende: String?
)