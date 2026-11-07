package com.example.askly.data.viewmodel

import androidx.lifecycle.ViewModel
import com.example.askly.data.repository.AuthRepository

class AuthViewModel (
    private val repository: AuthRepository
) : ViewModel() {

    fun registration (
        email: String,
        password: String,
        onResult: (Boolean, String) -> Unit
    ) {
        repository.registrationFunc(email, password) { success, result ->
            onResult(success)
        }
    }

    fun login (
        email: String,
        password: String,
        onResult: (Boolean, String) -> Unit
    ) {
        repository.loginFunc(email, password) { success, result ->
            onResult(success)
        }
    }
}