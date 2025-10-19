package com.aliosman.g101.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather")
data class Weather(
    @PrimaryKey(autoGenerate = true) val weatherId: Long = 0L,
    val weatherCondition: String
)
