package com.example.askly.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "RosterModel",
    primaryKeys = ["userId", "classroomId"],
    foreignKeys = [
        ForeignKey(
            entity = UserModel::class,
            parentColumns = ["userId"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ClassroomModel::class,
            parentColumns = ["classroomId"],
            childColumns = ["classroomId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("classroomId")]
)
data class RosterModel (
    val userId: Int,
    val classroomId: Int,
    val joinedAt: Long = System.currentTimeMillis(),
    val sortOrder: Int,
    val isBlocked: Boolean = false
)