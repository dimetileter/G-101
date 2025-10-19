package com.aliosman.g101.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "sizes")
data class Size(
    @PrimaryKey(autoGenerate = true) val sizeId: Long = 0L,
    val sizeNum: String
)
