package com.example.askly.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.askly.data.dao.QuestionDao
import com.example.askly.data.model.QuestionModel

@Database ( entities = [QuestionModel::class], version = 3)

abstract class AppDatabase : RoomDatabase() {
    abstract fun questionDao() : QuestionDao
}