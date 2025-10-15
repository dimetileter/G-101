package com.aliosman.g101.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "clothing_texture",
    primaryKeys = ["clothingId", "textureId"],
    foreignKeys = [
        ForeignKey(Clothes::class, parentColumns = ["clothingId"], childColumns = ["clothingId"], onDelete = ForeignKey.CASCADE),
        ForeignKey(Texture::class, parentColumns = ["textureId"], childColumns = ["textureId"], onDelete = ForeignKey.CASCADE)
    ],
    indices = [
        Index("clothingId"),
        Index("textureId")
    ]
)
data class ClothingTexture(
    val clothingId: Long,
    val textureId: Long
)
