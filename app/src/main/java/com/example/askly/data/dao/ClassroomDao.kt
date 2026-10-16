package com.example.askly.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.askly.data.model.ClassroomModel
import com.example.askly.data.model.RosterModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ClassroomDao {

    @Insert
    suspend fun insert(classroom : ClassroomModel): Long

    @Query("SELECT * FROM ClassroomModel WHERE joinCode = :joinCode")
    suspend fun getByJoinCode(joinCode: String): ClassroomModel?

    @Query("SELECT * FROM ClassroomModel WHERE ownerId = :ownerId")
    suspend fun getClassroomsOwned(ownerId: Int): Flow<List<ClassroomModel>>

    @Update
    suspend fun update(classroom : ClassroomModel)

    @Delete
    suspend fun delete(classroom : ClassroomModel)
}