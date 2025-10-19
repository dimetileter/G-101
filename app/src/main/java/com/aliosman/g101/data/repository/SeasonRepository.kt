package com.aliosman.g101.data.repository

import androidx.lifecycle.LiveData
import com.aliosman.g101.data.dao.SeasonDao
import com.aliosman.g101.data.entity.Season

class SeasonRepository(private val seasonDao: SeasonDao) {

    // Get all seasons
    suspend fun getAllSeasons(): LiveData<List<Season>> {
        return seasonDao.getAllSeason()
    }

}