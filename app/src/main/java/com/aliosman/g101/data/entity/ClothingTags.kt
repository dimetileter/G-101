package com.aliosman.g101.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "clothing_tags",
    foreignKeys = [
        ForeignKey(
            entity = Clothes::class,
            parentColumns = ["clothesId"],
            childColumns = ["clothingId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Tag::class,
            parentColumns = ["tagId"],
            childColumns = ["tagId"],
            onDelete = ForeignKey.CASCADE)
    ],
    indices = [
        Index("clothingId"),
        Index("tagId")
    ]
)
data class ClothingTags(
    val clothingId: Long,
    val tagId: Long
)
