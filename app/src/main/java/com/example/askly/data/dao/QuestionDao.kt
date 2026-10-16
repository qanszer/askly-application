package com.example.askly.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.askly.data.model.QuestionModel
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionDao {
    @Query("SELECT * FROM QuestionModel")
    fun getAllQuestions() : Flow<List<QuestionModel>>

    @Insert
    suspend fun insert(question : QuestionModel)

    @Update
    suspend fun update(question : QuestionModel)

    @Delete
    suspend fun delete(question : QuestionModel)
}