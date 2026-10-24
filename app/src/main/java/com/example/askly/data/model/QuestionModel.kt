package com.example.askly.data.model

data class QuestionModel (
    val questionId: String,
    val classroomId: String = "",
    val authorId: String = "",
    val questionText: String,
    val submittedAt: Long = System.currentTimeMillis(),
    val isDeleted: Boolean = false
)