package com.example.proyecto001.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "category")
class Category (
    @PrimaryKey(autoGenerate = true) val cateId: Int,
    @ColumnInfo(name = "cate_name") val cateName: String?,
    @ColumnInfo(name = "cate_mail") val cateDesc: String?,
    @ColumnInfo(name = "cate_icon") val cateIcon: String?
)