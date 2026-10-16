package com.example.askly.data

import com.example.askly.data.dao.ClassroomDao
import com.example.askly.data.dao.QuestionDao
import com.example.askly.data.dao.RosterDao
import com.example.askly.data.dao.UpvoteDao
import com.example.askly.data.dao.UserDao
import com.example.askly.data.model.ClassroomModel
import com.example.askly.data.model.QuestionModel
import com.example.askly.data.model.UserModel
import kotlinx.coroutines.flow.Flow

class AsklyRepository (
    private val classroomDao: ClassroomDao,
    private val questionDao: QuestionDao,
    private val userDao: UserDao,
    private val rosterDao: RosterDao,
    private val upvoteDao: UpvoteDao,
) {
    fun getOwnedClassrooms(ownerId: Int): Flow<List<ClassroomModel>> =
        classroomDao.getOwned(ownerId)

    val classroomList : Flow<List<ClassroomModel>> = classroomDao.getAllClassrooms()
    val questionList : Flow<List<QuestionModel>> = questionDao.getAllQuestions()

    // Classroom
    suspend fun classroomInsert(classroom : ClassroomModel) {
        classroomDao.insert(classroom)
    }
    suspend fun classroomUpdate(classroom : ClassroomModel) {
        classroomDao.update(classroom)
    }
    suspend fun classroomDelete(classroom : ClassroomModel) {
        classroomDao.delete(classroom)
    }

    // Question
    suspend fun questionInsert(question : QuestionModel) {
        questionDao.insert(question)
    }
    suspend fun questionUpdate(question : QuestionModel) {
        questionDao.update(question)
    }
    suspend fun questionDelete(question : QuestionModel) {
        questionDao.delete(question)
    }

    // User
    suspend fun userInsert(user : UserModel) {
        userDao.insert(user)
    }
}