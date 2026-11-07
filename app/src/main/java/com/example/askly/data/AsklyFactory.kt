package com.example.askly.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.askly.data.repository.AsklyRepository
import com.example.askly.data.repository.AuthRepository
import com.example.askly.data.viewmodel.AsklyViewModel
import com.example.askly.data.viewmodel.AuthViewModel

class AsklyFactory (
    private val repository: AsklyRepository,
    private val authRepository: AuthRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(
                AsklyViewModel::class.java
        )) {
            @Suppress("UNCHECKED-CAST")
            return AsklyViewModel(repository) as T
        }

        if(modelClass.isAssignableFrom(
                AuthViewModel::class.java
        )) {
            @Suppress("UNCHECKED-CAST")
            return AuthViewModel(authRepository) as T
        }

        throw IllegalArgumentException(
            "Unknown view model"
        )
    }
}