package com.aliosman.g101.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
class Favorite (
    @PrimaryKey(autoGenerate = true) val favId: Long = 0L,
    val clothingId: Long,
    val createdAt: Long = System.currentTimeMillis()
)