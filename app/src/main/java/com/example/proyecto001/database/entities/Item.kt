package com.example.proyecto001.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "items")
class Item(
    val itemName: String,
    val itemMont: String,
    val itemCate: String
){
    @PrimaryKey(autoGenerate = true)
    var itemId: Int = 0
}