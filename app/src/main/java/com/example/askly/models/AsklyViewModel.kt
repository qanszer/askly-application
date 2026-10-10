package com.example.askly.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AsklyViewModel : ViewModel() {
    var questionList by mutableStateOf(
        value = listOf(
            QuestionModel(
                questionId = 1,
                classroomId = 1,
                authorId = 1,
                questionText = "Is mobile development more lucrative than web development right now?"
            ),
            QuestionModel(
                questionId = 2,
                classroomId = 1,
                authorId = 1,
                questionText = "Attendance po sir present po"
            )
        )
    )

    fun addQuestion (questionText: String) {
        val newQuestion = QuestionModel(
            questionId = (questionList.maxOfOrNull { it.questionId } ?: 0) + 1,
            classroomId = (questionList.maxOfOrNull { it.questionId } ?: 0) + 1,
            authorId = (questionList.maxOfOrNull { it.questionId } ?: 0) + 1,
            questionText = questionText
        )
        questionList += newQuestion
    }

    fun deleteQuestion (questionId: Int) {
        questionList = questionList.filter {
            it.questionId != questionId
        }
    }

    fun getQuestionById (questionId: Int) : QuestionModel? {
        return questionList.find {
            it.questionId == questionId
        }
    }

    fun updateQuestion (
        questionId: Int,
        questionName: String
    ) {
        questionList = questionList.map {
                questionData ->
            if (questionData.questionId == questionId) {
                questionData.copy (
                    questionId = questionId,
                    questionText = questionName
                )
            } else {
                questionData
            }
        }
    }

    var classroomList by mutableStateOf(
        value = listOf(
            ClassroomModel(
                classroomId = 1,
                joinCode = "ASDF",
                classroomName = "Mobile Development",
                ownerId = 1
            ),
            ClassroomModel(
                classroomId = 2,
                joinCode = "QWER",
                classroomName = "Nihongo",
                ownerId = 1
            )
        )
    )
}
