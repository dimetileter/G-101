package com.aliosman.g101.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "combine_items",
    primaryKeys = ["combineId", "clothingId"],
    foreignKeys = [
        ForeignKey(entity = Combine::class, parentColumns = ["combineId"], childColumns = ["combineId"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Clothes::class, parentColumns = ["clothesId"], childColumns = ["clothingId"], onDelete = ForeignKey.CASCADE)
    ],
    indices = [
        Index("combineId"),
        Index("clothingId")
    ]
)
data class CombineItem(
    val combineId: Long,
    val clothingId: Long
)