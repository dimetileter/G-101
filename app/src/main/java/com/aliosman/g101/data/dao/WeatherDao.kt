package com.aliosman.g101.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.aliosman.g101.data.entity.Weather

@Dao
interface WeatherDao {

    // Get all weather conditions
    @Query("SELECT * FROM WEATHER ORDER BY weatherId ASC")
    suspend fun getAllWeatherConditions(): LiveData<List<Weather>>

}