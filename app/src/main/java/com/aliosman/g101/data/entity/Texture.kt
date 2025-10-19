package com.aliosman.g101.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "textures")
data class Texture(
    @PrimaryKey(autoGenerate = true) val textureId: Long = 0L,
    val textureName: String
)
