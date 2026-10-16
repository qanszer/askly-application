package com.example.askly.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "QuestionModel",
    foreignKeys = [
        ForeignKey(
            entity = ClassroomModel::class,
            parentColumns = ["classroomId"],
            childColumns = ["classroomId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = UserModel::class,
            parentColumns = ["userId"],
            childColumns = ["authorId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("classroomId"), Index("authorId")]
)
data class QuestionModel (
    @PrimaryKey(autoGenerate = true) val questionId: Int = 0,
    val classroomId: Int,
    val authorId: Int,
    val questionText: String,
    val submittedAt: Long = System.currentTimeMillis(),
    val isDeleted: Boolean = false
)