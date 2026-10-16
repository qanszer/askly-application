package com.example.askly.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.askly.data.dao.ClassroomDao
import com.example.askly.data.dao.QuestionDao
import com.example.askly.data.dao.RosterDao
import com.example.askly.data.dao.UpvoteDao
import com.example.askly.data.dao.UserDao
import com.example.askly.data.model.ClassroomModel
import com.example.askly.data.model.QuestionModel
import com.example.askly.data.model.RosterModel
import com.example.askly.data.model.UpvoteModel
import com.example.askly.data.model.UserModel

@Database(
    entities = [
        ClassroomModel::class,
        QuestionModel::class,
        UserModel::class,
        RosterModel::class,
        UpvoteModel::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun classroomDao() : ClassroomDao
    abstract fun questionDao() : QuestionDao
    abstract fun userDao() : UserDao
    abstract fun rosterDao() : RosterDao
    abstract fun upvoteDao() : UpvoteDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "askly_database"
                ).build().also { instance = it }
            }
    }
}