package com.example.data.repository

import com.example.data.api.CoursesApiService
import com.example.data.db.dao.FavoriteCourseDao
import com.example.data.mappers.*
import com.example.domain.models.Course
import com.example.domain.repository.CoursesRepository

class CoursesRepositoryImpl(
    private val api: CoursesApiService,
    private val dao: FavoriteCourseDao
) : CoursesRepository {

    override suspend fun getCourses(): List<Course> {
        val courses = api.getCourses().map { it.toDomain() }
        val favorites = dao.getAllFavorites().map { it.id }.toSet()
        return courses.map { it.copy(isFavorite = favorites.contains(it.id)) }
    }

    override suspend fun getFavorites(): List<Course> =
        dao.getAllFavorites().map { it.toDomain() }

    override suspend fun toggleFavorite(course: Course) {
        if (course.isFavorite) dao.delete(course.toEntity())
        else dao.insert(course.copy(isFavorite = true).toEntity())
    }
}
