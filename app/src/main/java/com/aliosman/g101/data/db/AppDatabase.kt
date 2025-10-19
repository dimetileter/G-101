package com.aliosman.g101.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aliosman.g101.data.dao.ClothesDao
import com.aliosman.g101.data.entity.Clothes

@Database(
    entities = [Clothes::class],
    version = 1,
)
abstract class AppDatabase: RoomDatabase() {

    // Clothes Dao
    abstract fun clothesDao(): ClothesDao

    // Other DAO's
    //    ...


    // Veritabanı giriş ve çıkışlarını tek bir yerden kontrol et
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "gardirob_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}

