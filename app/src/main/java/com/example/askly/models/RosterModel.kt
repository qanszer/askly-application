package com.example.askly.models

data class RosterModel (
    val userId: Int,
    val classroomId: Int,
    val joinedAt: Long = System.currentTimeMillis(),
    val sortOrder: Int,
    val isBlocked: Boolean = false
)