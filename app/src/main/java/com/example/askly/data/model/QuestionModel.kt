package com.example.askly.data.model

data class QuestionModel (
    val questionId: Int = 0,
    val classroomId: Int,
    val authorId: Int,
    val questionText: String,
    val submittedAt: Long = System.currentTimeMillis(),
    val isDeleted: Boolean = false
)