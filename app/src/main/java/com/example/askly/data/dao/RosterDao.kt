package com.example.askly.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.askly.data.model.RosterModel
import kotlinx.coroutines.flow.Flow

@Dao
interface RosterDao {



    @Query("SELECT * FROM RosterModel")
    fun getRostersForUser() : Flow<List<RosterModel>>

    @Insert
    suspend fun joinRoster(roster : RosterModel)

    @Update
    suspend fun sortOrder(roster : RosterModel)

    @Update
    suspend fun isBlocked(roster : RosterModel)

    @Delete
    suspend fun leaveRoster(roster : RosterModel)
}