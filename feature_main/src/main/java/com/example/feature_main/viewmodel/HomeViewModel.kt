package com.example.feature_main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Course
import com.example.domain.repository.CoursesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: CoursesRepository) : ViewModel() {
    private val _courses = MutableStateFlow<List<Course>>(emptyList())
    val courses: StateFlow<List<Course>> = _courses

    init {
        loadCourses()
    }

    fun loadCourses() {
        viewModelScope.launch {
            _courses.value = repository.getCourses()
        }
    }

    fun toggleFavorite(course: Course) {
        viewModelScope.launch {
            repository.toggleFavorite(course)
            _courses.value = repository.getCourses()
        }
    }
}
