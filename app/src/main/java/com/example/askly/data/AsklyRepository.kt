package com.example.askly.data

import com.example.askly.data.dao.QuestionDao
import com.example.askly.data.model.QuestionModel
import kotlinx.coroutines.flow.Flow

class AsklyRepository (private val questionDao: QuestionDao) {
    val questionList : Flow<List<QuestionModel>> = questionDao.getAllQuestions()

    suspend fun questionAdd(question : QuestionModel) {
        questionDao.insert(question)
    }

    suspend fun questionEdit(question : QuestionModel) {
        questionDao.update(question)
    }

    suspend fun questionRemove(question : QuestionModel) {
        questionDao.delete(question)
    }
}