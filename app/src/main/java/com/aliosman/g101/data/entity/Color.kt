package com.aliosman.g101.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "colors")
data class Color(
    @PrimaryKey(autoGenerate = true) val colorId: Long = 0L,
    val colorName: String,
    val colorCode: String?
)
