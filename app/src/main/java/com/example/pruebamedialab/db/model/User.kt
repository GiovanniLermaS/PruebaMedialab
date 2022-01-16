package com.example.pruebamedialab.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = false) val id: Int?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "image") val image: Int?,
    @ColumnInfo(name = "bio") val bio: String?,
    @ColumnInfo(name = "email") val email: String?,
)