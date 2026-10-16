package com.example.askly.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.askly.data.model.UpvoteModel
import kotlinx.coroutines.flow.Flow

@Dao
interface UpvoteDao {
    @Query("SELECT * FROM UpvoteModel")
    fun getAllUpvotes() : Flow<List<UpvoteModel>>

    @Insert
    suspend fun insert(upvote : UpvoteModel)

    @Update
    suspend fun update(upvote : UpvoteModel)

    @Delete
    suspend fun delete(upvote : UpvoteModel)
}