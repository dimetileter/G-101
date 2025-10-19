package com.aliosman.g101.data.repository

import androidx.lifecycle.LiveData
import com.aliosman.g101.data.dao.FavoritesDao
import com.aliosman.g101.data.entity.Favorite

class FavoritesRepository(private val favoritesDao: FavoritesDao) {

    // Insert
    suspend fun insertFavorites(favorite: Favorite) {
        favoritesDao.insertFavorites(favorite)
    }

    // Delete
    suspend fun deleteFavorites(favorite: Favorite) {
        favoritesDao.deleteFavorites(favorite)
    }

    // Get all
    suspend fun getAllFavorites(): LiveData<List<Favorite>> {
        return favoritesDao.getAllFavorites()
    }
}