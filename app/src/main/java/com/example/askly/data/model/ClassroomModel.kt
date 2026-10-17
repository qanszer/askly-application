package com.example.askly.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ClassroomModel (
    @PrimaryKey(autoGenerate = true)
    val classroomId: String = "",
    val joinCode: String,
    val classroomName: String,
    val ownerId: Int,
    val createdAt: Long = System.currentTimeMillis()
)