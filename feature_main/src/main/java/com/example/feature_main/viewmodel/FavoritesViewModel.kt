package com.example.feature_main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Course
import com.example.domain.repository.CoursesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class FavoritesViewModel(private val repository: CoursesRepository) : ViewModel() {
    val favorites = MutableStateFlow<List<Course>>(emptyList())

    init {
        loadFavorites()
    }

    fun loadFavorites() {
        viewModelScope.launch {
            favorites.value = repository.getFavorites()
        }
    }
}
