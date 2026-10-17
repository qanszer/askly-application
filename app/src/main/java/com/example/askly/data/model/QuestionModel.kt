package com.example.askly.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class QuestionModel (
    @PrimaryKey(autoGenerate = true)
    val questionId: String,
    val classroomId: String = "",
    val authorId: String = "",
    val questionText: String,
    val submittedAt: Long = System.currentTimeMillis(),
    val isDeleted: Boolean = false
)