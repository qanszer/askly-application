package com.example.askly.data.model

data class ClassroomModel (
    val classroomId: String = "",
    val joinCode: String,
    val classroomName: String,
    val ownerId: Int,
    val createdAt: Long = System.currentTimeMillis()
)