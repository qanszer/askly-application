package com.example.askly.data.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.askly.data.AsklyRepository
import com.example.askly.data.model.ClassroomModel
import com.example.askly.data.model.QuestionModel
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class AsklyViewModel(
    private val asklyRepository: AsklyRepository
) : ViewModel() {
    var questionList = asklyRepository.questionList

    fun addQuestion (
        question: String,
    ) {
        viewModelScope.launch {
            asklyRepository.questionAdd(
                QuestionModel(
                    classroomId = 1,
                    authorId = 1,
                    questionText = question,
                )
            )
        }
    }

    fun deleteQuestion (questionId: Int) {
        viewModelScope.launch {
            val question = questionList.first().find{
                it.questionId == questionId
            }

            question?.let {
                asklyRepository.questionRemove(question)
            }
        }
    }

    fun updateQuestion (
        id: Int,
        text: String
    ) {
        viewModelScope.launch {
            val question = questionList.first().find{
                it.questionId == id
            }

            question?.let {
                asklyRepository.questionEdit(
                    it.copy(
                        questionText = text
                    )
                )
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
