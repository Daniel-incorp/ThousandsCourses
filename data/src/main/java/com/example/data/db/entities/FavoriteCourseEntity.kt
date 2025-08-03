package com.example.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_courses")
data class FavoriteCourseEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val isFavorite: Boolean
)
