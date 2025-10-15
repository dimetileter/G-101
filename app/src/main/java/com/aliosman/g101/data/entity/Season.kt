package com.aliosman.g101.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "seasons")
data class Season(
    @PrimaryKey(autoGenerate = true) val  seasonId: Long = 0L,
    val seasonName: String
)
