package com.aliosman.g101.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.aliosman.g101.data.entity.Category
import com.aliosman.g101.data.entity.Clothes

@Dao
interface ClothesDao {

    // Insert
    @Insert
    suspend fun insertClothing(clothes: Clothes)

    // Delete
    @Delete
    suspend fun deleteClothing(clothes: Clothes)

    // Update
    @Update
    suspend fun updateClothing(clothes: Clothes)

    // Order by creating time
    @Query("SELECT * FROM clothes ORDER BY createdAt DESC")
    suspend fun getAllClothes(): List<Clothes>

    // Get specific categories's clothes
    @Query("SELECT * FROM CLOTHES WHERE categoryId = :categoryId ORDER BY clothingName ASC")
    suspend fun getClothesByCategory(categoryId: Int): List<Clothes>
}