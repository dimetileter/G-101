package com.aliosman.g101.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.aliosman.g101.data.entity.Favorite

@Dao
interface FavoritesDao {

    // Insert
    @Insert
    suspend fun insertFavorites(favorite: Favorite)

    // Delete
    @Delete
    suspend fun deleteFavorites(favorite: Favorite)

    // Get all favorites
    @Query("SELECT * FROM FAVORITES ORDER BY favId ASC")
    suspend fun getAllFavorites(): LiveData<List<Favorite>>
}