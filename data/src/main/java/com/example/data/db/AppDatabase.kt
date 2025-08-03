package com.example.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.db.dao.FavoriteCourseDao
import com.example.data.db.entities.FavoriteCourseEntity

@Database(entities = [FavoriteCourseEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteCourseDao(): FavoriteCourseDao
}