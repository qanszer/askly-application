package com.example.askly.models

data class QuestionModel (
    val questionId: Int = 0,
    val classroomId: Int,
    val authorId: Int,
    val questionText: String,
    val submittedAt: Long = System.currentTimeMillis(),
    val isDeleted: Boolean = false
)