package com.example.askly.data

import android.app.Application
import kotlin.getValue

class AsklyApplication : Application() {
    val database by lazy { AppDatabase.getInstance(this) }
    val repository by lazy {
        AsklyRepository(
            database.classroomDao(),
            database.questionDao(),
            database.userDao(),
            database.rosterDao(),
            database.upvoteDao()
        )
    }
}