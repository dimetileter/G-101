package com.aliosman.g101.data.repository

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.aliosman.g101.data.dao.ClothesDao
import com.aliosman.g101.data.entity.Clothes

class ClothesRepository(private val clothesDao: ClothesDao) {

    // Insert
    suspend fun insertClothes(clothes: Clothes) {
        clothesDao.insertClothing(clothes)
    }

    //Update
    suspend fun updateClothes(clothes: Clothes) {
        clothesDao.updateClothing(clothes)
    }

    // Delete clothes
    suspend fun deleteClothes(clothes: Clothes) {
        clothesDao.deleteClothing(clothes)
    }

    // Get all
    suspend fun getAllClothes(): List<Clothes> {
        return clothesDao.getAllClothes()
    }

    // Get clothes by category
    suspend fun getClothesByCategory(categoryId: Int): List<Clothes> {
        return clothesDao.getClothesByCategory(categoryId)
    }

}