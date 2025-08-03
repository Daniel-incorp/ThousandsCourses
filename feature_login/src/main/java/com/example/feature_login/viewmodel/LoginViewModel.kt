package com.example.feature_login.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel : ViewModel() {

    private val _isLoginEnabled = MutableStateFlow(false)
    val isLoginEnabled: StateFlow<Boolean> = _isLoginEnabled

    fun onCredentialsChanged(email: String, password: String) {
        _isLoginEnabled.value = email.isNotBlank() && password.isNotBlank()
    }
}