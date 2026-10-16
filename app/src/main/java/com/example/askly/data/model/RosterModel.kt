package com.example.askly.data.model

data class RosterModel (
    val userId: Int,
    val classroomId: Int,
    val joinedAt: Long = System.currentTimeMillis(),
    val sortOrder: Int,
    val isBlocked: Boolean = false
)