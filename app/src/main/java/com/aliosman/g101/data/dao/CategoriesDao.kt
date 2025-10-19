package com.aliosman.g101.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.aliosman.g101.data.entity.Category

@Dao
interface CategoriesDao {

    // Insert
    @Insert
    suspend fun insertCategories(category: Category)

    // Delete
    @Delete
    suspend fun deleteCategories(category: Category)

    // Gett all categories as ordered by
    @Query("SELECT * FROM CATEGORIES ORDER BY categoryId ASC")
    suspend fun getAllCategories(): LiveData<List<Category>>
}