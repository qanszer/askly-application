package com.example.askly.data.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.askly.data.AsklyRepository
import com.example.askly.data.model.ClassroomModel
import com.example.askly.data.model.QuestionModel
import kotlinx.coroutines.launch
import androidx.compose.runtime.State

class AsklyViewModel(
    private val asklyRepository: AsklyRepository
) : ViewModel() {
    private val _questions = mutableStateOf<List<QuestionModel>>(emptyList())
    val questions: State<List<QuestionModel>> = _questions

    init {
        getQuestion()
    }

    fun getQuestion() {
        viewModelScope.launch {
            asklyRepository.getQuestion { result ->
                _questions.value = result
            }
        }
    }

    fun addQuestion (
        question: String,
    ) {
        viewModelScope.launch {
            asklyRepository.questionAdd(
                QuestionModel(
                    questionId = "",
                    classroomId = "",
                    authorId = "",
                    questionText = question
                )
            )
        }
    }

    fun deleteQuestion (questionId: String) {
        viewModelScope.launch {
            val question = questions.value.find {
                it.questionId == questionId
            }

            question?.let {
                asklyRepository.questionRemove(it)
            }
        }
    }

    fun updateQuestion (
        id: String,
        text: String
    ) {
        viewModelScope.launch {
            asklyRepository.questionEdit(
                QuestionModel(
                    questionId = id,
                    questionText = text
                )
            )
        }
    }

    var classroomList by mutableStateOf(
        value = listOf(
            ClassroomModel(
                classroomId = "",
                joinCode = "ASDF",
                classroomName = "Mobile Development",
                ownerId = 1
            ),
            ClassroomModel(
                classroomId = "",
                joinCode = "QWER",
                classroomName = "Nihongo",
                ownerId = 1
            )
        )
    )
}
