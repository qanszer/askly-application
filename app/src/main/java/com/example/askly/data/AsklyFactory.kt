package com.example.askly.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.askly.data.viewmodel.AsklyViewModel
import kotlin.jvm.java

class AsklyFactory (
    private val repository: AsklyRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(
                AsklyViewModel::class.java
        )) {
            @Suppress("UNCHECKED-CAST")
            return AsklyViewModel(repository) as T
        }

        throw IllegalArgumentException(
            "Error"
        )
    }
}