package com.example.askly.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "ClassroomModel",
    foreignKeys = [
        ForeignKey(
            entity = UserModel::class,
            parentColumns = ["userId"],
            childColumns = ["ownerId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index("ownerId"),
        Index(value = ["joinCode"], unique = true)
    ]
)
data class ClassroomModel (
    @PrimaryKey(autoGenerate = true) val classroomId: Int = 0,
    val joinCode: String,
    val classroomName: String,
    val ownerId: Int,
    val createdAt: Long = System.currentTimeMillis()
)