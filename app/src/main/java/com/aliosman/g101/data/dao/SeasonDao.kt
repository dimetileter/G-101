package com.aliosman.g101.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.aliosman.g101.data.entity.Season

interface SeasonDao {

    // Get all season
    @Query("SELECT * FROM SEASONS ORDER BY seasonId ASC")
    suspend fun getAllSeason(): LiveData<List<Season>>
}