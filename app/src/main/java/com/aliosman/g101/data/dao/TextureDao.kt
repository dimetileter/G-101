package com.aliosman.g101.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.aliosman.g101.data.entity.Texture

@Dao
interface TextureDao {

    // Insert
    @Insert
    suspend fun insertTexture(texture: Texture)

    // Get all
    @Query("SELECT * FROM TEXTURES ORDER BY textureId ASC")
    suspend fun getAllTextures(): List<Texture>
}