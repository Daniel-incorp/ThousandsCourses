package com.example.data.mappers

import com.example.data.db.entities.FavoriteCourseEntity
import com.example.domain.models.Course

fun FavoriteCourseEntity.toDomain() = Course(id, title, description, isFavorite)
fun Course.toEntity() = FavoriteCourseEntity(id, title, description, isFavorite)