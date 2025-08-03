package com.example.domain.repository

import com.example.domain.models.Course

interface CoursesRepository {
    suspend fun getCourses(): List<Course>
    suspend fun getFavorites(): List<Course>
    suspend fun toggleFavorite(course: Course)
}