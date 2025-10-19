package com.aliosman.g101.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "clothing_weather",
    primaryKeys = ["clothingId", "weatherId"],
    foreignKeys = [
        ForeignKey(Clothes::class, parentColumns = ["clothingId"], childColumns = ["clothingId"], onDelete = ForeignKey.CASCADE),
        ForeignKey(Weather::class, parentColumns = ["weatherId"], childColumns = ["weatherId"], onDelete = ForeignKey.CASCADE)
        ],

    indices = [
        Index("clothingId"),
        Index("weatherId")
    ]
)
data class ClothingWeather(
    val clothingId: Long,
    val weatherId: Long
)
