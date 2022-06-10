package com.example.proyecto001.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.proyecto001.database.dao.CategoryDAO
import com.example.proyecto001.database.dao.ItemDAO
import com.example.proyecto001.database.dao.UserDAO
import com.example.proyecto001.database.entities.Category
import com.example.proyecto001.database.entities.Item
import com.example.proyecto001.database.entities.User
import com.example.proyecto001.database.utils.DATABASE_NAME

@Database(
    entities = [User::class, Item::class, Category::class],
    version = 1
)
abstract class FinanzasDatabase: RoomDatabase() {
    abstract fun userDAO(): UserDAO
    abstract fun itemDAO(): ItemDAO
    abstract fun categoryDAO(): CategoryDAO

    companion object{
        private var INSTANCE: FinanzasDatabase? = null

        fun getInstance(context: Context): FinanzasDatabase? {
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FinanzasDatabase::class.java,
                        DATABASE_NAME
                    ).fallbackToDestructiveMigration().build()
                }
                return instance
            }
        }
    }
}