package com.example.askly.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class QuestionModel (
    @PrimaryKey(autoGenerate = true) val questionId: Int = 0,
    val classroomId: Int,
    val authorId: Int,
    val questionText: String,
    val submittedAt: Long = System.currentTimeMillis(),
    val isDeleted: Boolean = false
)