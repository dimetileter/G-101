package com.aliosman.g101.data.repository

import androidx.lifecycle.LiveData
import com.aliosman.g101.data.dao.WeatherDao
import com.aliosman.g101.data.entity.Weather

class WeatherRepository(private val weatherDao: WeatherDao) {

    // Get all weather conditions
    suspend fun getAllWeatherConditions(): LiveData<List<Weather>> {
        return weatherDao.getAllWeatherConditions()
    }
}