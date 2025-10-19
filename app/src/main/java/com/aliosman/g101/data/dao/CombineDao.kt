package com.aliosman.g101.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.aliosman.g101.data.entity.Combine

@Dao
interface CombineDao {

    // Insert
    @Insert
    suspend fun insertCombine(combine: Combine)

    // Delete
    @Delete
    suspend fun deleteCombine(combine: Combine)

    // Get all combines
    @Query("SELECT * FROM COMBINES ORDER BY combineId ASC")
    suspend fun getAllCombines(): List<Combine>

}