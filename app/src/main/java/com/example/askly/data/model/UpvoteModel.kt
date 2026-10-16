package com.example.askly.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "UpvoteModel",
    primaryKeys = ["questionId", "userId"],
    foreignKeys = [
        ForeignKey(
            entity = QuestionModel::class,
            parentColumns = ["questionId"],
            childColumns = ["questionId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = UserModel::class,
            parentColumns = ["userId"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("userId")]
)
data class UpvoteModel (
    val questionId: Int,
    val userId: Int,
)