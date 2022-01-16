package com.example.pruebamedialab.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pruebamedialab.db.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM User")
    fun getUsers(): LiveData<List<User>>

    @Query("SELECT * FROM User WHERE id=:id")
    suspend fun getUserById(id: Int): User

    @Query("DELETE FROM User WHERE id=:id")
    suspend fun deleteUserById(id: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setUser(user: User): Long
}