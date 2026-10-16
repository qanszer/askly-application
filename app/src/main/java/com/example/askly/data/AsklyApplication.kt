package com.example.askly.data

import android.app.Application
import androidx.room.Room
import kotlin.getValue

class AsklyApplication : Application() {
    val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "askly_database"
        ).build()
    }

    val asklyRepository by lazy {
        AsklyRepository(database.questionDao())
    }
}