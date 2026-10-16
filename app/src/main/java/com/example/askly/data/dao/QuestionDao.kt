package com.example.askly.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.askly.data.model.QuestionModel
import com.example.askly.data.model.UpvoteModel
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionDao {
    @Query("SELECT * FROM QuestionModel")
    fun getAllQuestions() : Flow<List<QuestionModel>>

    @Insert
    suspend fun insert(emp : QuestionModel)

    @Update
    suspend fun update(emp : QuestionModel)

    @Delete
    suspend fun delete(emp : QuestionModel)
}