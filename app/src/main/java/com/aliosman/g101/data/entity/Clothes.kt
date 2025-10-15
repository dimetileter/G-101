package com.aliosman.g101.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "clothes",
    // Foreign keys
    foreignKeys = [
        ForeignKey(Category::class, parentColumns = ["categoryId"], childColumns = ["categoryId"], onDelete = ForeignKey.SET_NULL),
        ForeignKey(Season::class, parentColumns = ["seasonId"], childColumns = ["seasonId"], onDelete = ForeignKey.SET_NULL),
        ForeignKey(Color::class, parentColumns = ["colorId"], childColumns = ["colorId"], onDelete = ForeignKey.SET_NULL),
        ForeignKey(Brand::class, parentColumns = ["brandId"], childColumns = ["brandId"], onDelete = ForeignKey.SET_NULL),
        ForeignKey(Size::class, parentColumns = ["sizeId"], childColumns = ["sizeId"], onDelete = ForeignKey.SET_NULL),
        ForeignKey(Material::class, parentColumns = ["materialId"], childColumns = ["materialId"], onDelete = ForeignKey.SET_NULL),
    ],
    indices = [
        Index("categoryId"),
        Index("seasonId"),
        Index("colorId"),
        Index("brandId"),
        Index("sizeId"),
        Index("materialId"),
    ]
)
data class Clothes(
    @PrimaryKey(autoGenerate = true) val clothesId: Long = 0L,
    val clothingName: String,
    val clothingDesc: String?,
    val barcodeNum: String?,
    val productNum: String?,
    val categoryId: Long?,
    val seasonId: Long?,
    val colorId: Long?,
    val brandId: Long?,
    val sizeId: Long?,
    val materialId: Long?,
    val imagePath:String?,       // Internal image path
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long? = null
)
