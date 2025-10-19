package com.aliosman.g101.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "brands")
data class Brand(
    @PrimaryKey(autoGenerate = true) val brandId: Long = 0L,
    val brandName: String
)
