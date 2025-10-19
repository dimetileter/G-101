package com.aliosman.g101.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "materials")
data class Material(
    @PrimaryKey(autoGenerate = true) val materialId: Long = 0L,
    val materialName: String
)
