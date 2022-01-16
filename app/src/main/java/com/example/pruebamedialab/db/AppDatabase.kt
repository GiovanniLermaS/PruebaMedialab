package com.example.pruebamedialab.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pruebamedialab.db.dao.UserDao
import com.example.pruebamedialab.db.model.User

@Database(
    entities = [User::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}