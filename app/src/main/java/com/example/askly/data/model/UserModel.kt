package com.example.askly.data.model

data class UserModel (
    val userId: String = "",
    val firstName: String,
    val lastName: String,
    val email: String,
    val isAnonymous: Boolean = true,
    val createdAt: Long = System.currentTimeMillis()
)