package com.example.pruebamedialab.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class User(
    @ColumnInfo(name = "name") var name: String?,
    @ColumnInfo(name = "image") val image: Int?,
    @ColumnInfo(name = "bio") var bio: String?,
    @ColumnInfo(name = "email") var email: String?,
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}