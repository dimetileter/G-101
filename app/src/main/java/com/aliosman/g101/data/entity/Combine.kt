package com.aliosman.g101.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "combines")
data class Combine(
    @PrimaryKey(autoGenerate = true) val combineId: Long = 0L,
    val combineName: String,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long? = null
)

