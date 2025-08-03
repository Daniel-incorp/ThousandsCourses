package com.example.data.mappers

import com.example.data.api.dto.CourseDto
import com.example.domain.models.Course

fun CourseDto.toDomain() = Course(id, title, description, false)