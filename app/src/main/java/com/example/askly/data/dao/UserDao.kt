package com.example.askly.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.askly.data.model.UserModel
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM UserModel WHERE userId = :userId")
    suspend fun getUserById(userId: Int): UserModel?

    @Insert
    suspend fun insert(user : UserModel)

}