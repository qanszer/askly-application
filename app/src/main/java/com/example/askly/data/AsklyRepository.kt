package com.example.askly.data

import com.example.askly.data.model.QuestionModel
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.tasks.await
import java.util.Date

class AsklyRepository () {
    private val db = FirebaseFirestore.getInstance()

    suspend fun questionAdd(question : QuestionModel) {

        val question = hashMapOf(
            "classroomId" to question.classroomId,
            "authorId" to question.authorId,
            "questionText" to question.questionText,
            "submittedAt" to Date(question.submittedAt),
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
        onResult: (List<QuestionModel>) -> Unit
    ) {

        db.collection("coll_questions")
            .addSnapshotListener { snapshots, error ->
                if (error != null) {
                    println("Listen failed: ${error.message}")
                    onResult(emptyList())
                    return@addSnapshotListener
                }

                if (snapshots != null) {
                    val questions = snapshots.documents.map { document ->
                        QuestionModel(
                            questionId = document.id,
                            classroomId = document.getString("classroomId") ?: "",
                            authorId = document.getString("authorId") ?: "",
                            questionText = document.getString("questionText") ?: "",
                            submittedAt = document
                                .getTimestamp("submittedAt")?.toDate()?.time ?: 0L,
                            isDeleted = document.getBoolean("isDeleted") ?: false
                        )
                    }
                    onResult(questions)
                }
            }
    }

    suspend fun questionEdit(question : QuestionModel) {

        db.collection("coll_questions")
            .document(question.questionId)
            .update("questionText", question.questionText)
            .addOnSuccessListener {
                print("Question edited succesffuly")
            }
            .addOnFailureListener { error ->
                print("Question edit failed: " + error)
            }
            .await()
    }

    suspend fun questionRemove(question : QuestionModel) {

        db.collection("coll_questions")
            .document(question.questionId)
            .update("isDeleted", true)
            .addOnSuccessListener {
                print("Question removed successfully")
            }
            .addOnFailureListener { error ->
                print("Question removal failed: " + error)
            }
            .await()
    }
}