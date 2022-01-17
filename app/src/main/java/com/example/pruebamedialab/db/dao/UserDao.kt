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
    fun getUsersLiveData(): LiveData<List<User>>

    @Query("SELECT * FROM User WHERE email=:email")
    suspend fun getUserByEmail(email: String): User

    @Query("DELETE FROM User WHERE id=:id")
    suspend fun deleteUserById(id: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setUser(user: User): Long

    @Query("UPDATE user SET name=:name, bio=:bio, email=:email WHERE id = :id")
    suspend fun updateUser(name: String?, bio: String?, email: String?, id: Int)
}