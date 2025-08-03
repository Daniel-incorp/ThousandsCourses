package com.example.data.api

import com.example.data.api.dto.CourseDto
import retrofit2.http.GET

interface CoursesApiService {
    @GET("courses")
    suspend fun getCourses(): List<CourseDto>
}