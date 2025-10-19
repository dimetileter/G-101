package com.aliosman.g101.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.aliosman.g101.data.entity.Brand

@Dao
interface BrandDao {

    // Insert
    @Insert
    suspend fun insertBrand(brand: Brand)

    // Get all
    @Query("SELECT * FROM BRANDS ORDER BY brandId ASC")
    suspend fun getAllBrand(): List<Brand>
}