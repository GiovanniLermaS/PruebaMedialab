package com.example.pruebamedialab.db.module

import android.content.Context
import androidx.room.Room
import com.example.pruebamedialab.db.AppDatabase
import com.example.pruebamedialab.db.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "result-service"
        ).build()
    }

    @Provides
    fun provideObjectDao(database: AppDatabase): UserDao {
        return database.userDao()
    }
}
