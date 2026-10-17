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
            .addOnSuccessListener {
                print("Question added succesffuly")
            }
            .addOnFailureListener { error ->
                print("Question addition failed: " + error)
            }
            .await()
    }

    suspend fun getQuestion(
        onDefault: (List<QuestionModel>) -> Unit
    ) {
        db.collection("coll_questions")
            .addSnapshotListener { snapshots, error ->
                if (error != null) {
                    println("Listen failed: ${error.message}")
                    onDefault(emptyList())
                    return@addSnapshotListener
                }

                if (snapshots != null) {
                    val employees = snapshots.documents.map {
                        document ->
                        QuestionModel(

                        )
                    }
                }
            }
    }

    suspend fun questionEdit(question : QuestionModel) {
        questionDao.update(question)

        db.collection("coll_questions")
            .addSnapshotListener { snapshots, error ->
                if (error != null) {
                    println("Listen failed: ${error.message}")
                    onDefault(emptyList())
                    return@addSnapshotListener
                }

                if (snapshots != null) {
                    val employees = snapshots.documents.map {
                            document ->
                        QuestionModel(
                            isDeleted = document.getBoolean("isDeleted") ?: 0,
                        )
                    }
                }
            }
    }

    suspend fun questionRemove(question : QuestionModel) {
        questionDao.delete(question)
    }
}