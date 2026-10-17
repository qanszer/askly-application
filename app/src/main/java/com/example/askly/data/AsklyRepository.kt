package com.example.askly.data

import com.example.askly.data.dao.QuestionDao
import com.example.askly.data.model.QuestionModel
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.tasks.await

private val db = FirebaseFirestore.getInstance()

class AsklyRepository (private val questionDao: QuestionDao) {
    val questionList : Flow<List<QuestionModel>> = questionDao.getAllQuestions()

    suspend fun questionAdd(question : QuestionModel) {
        questionDao.insert(question)

        val question = hashMapOf(
            "classroomId" to question.classroomId,
            "authorId" to question.authorId,
            "questionText" to question.questionText,
            "submittedAt" to question.submittedAt,
            "isDeleted" to question.isDeleted
        )

        db.collection("coll_questions")
            .add(question)
            .await()
    }

    suspend fun questionEdit(question : QuestionModel) {
        questionDao.update(question)
    }

    suspend fun questionRemove(question : QuestionModel) {
        questionDao.delete(question)
    }
}