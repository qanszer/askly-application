package com.example.askly.models

data class UserModel (
    val userId: Int = 0,
    val firstName: String,
    val lastName: String,
    val email: String,
    val isAnonymous: Boolean = true,
    val createdAt: Long = System.currentTimeMillis()
)