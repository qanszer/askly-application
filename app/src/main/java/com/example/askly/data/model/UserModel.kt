package com.example.askly.data.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "UserModel",
    indices = [Index(value = ["email"], unique = true)]
)
data class UserModel (
    @PrimaryKey(autoGenerate = true)
    val userId: Int = 0,
    val firstName: String,
    val lastName: String,
    val email: String,
    val isAnonymous: Boolean = true,
    val createdAt: Long = System.currentTimeMillis()
)