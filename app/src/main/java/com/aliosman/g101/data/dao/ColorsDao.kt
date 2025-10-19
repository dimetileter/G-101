package com.aliosman.g101.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.aliosman.g101.data.entity.Color

@Dao
interface ColorsDao {

    // Insert
    @Insert
    suspend fun insertColors(color: Color)

    // Get all colors
    @Query("SELECT * FROM COLORS ORDER BY colorId")
    suspend fun getAllColors(): List<Color>
}