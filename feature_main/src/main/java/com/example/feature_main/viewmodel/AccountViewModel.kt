package com.example.feature_main.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class AccountViewModel : ViewModel() {
    private val _message = MutableStateFlow("Здесь пока что ничего нет)")
    val message: StateFlow<String> = _message
}