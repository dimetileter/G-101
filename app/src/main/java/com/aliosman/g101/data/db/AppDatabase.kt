package com.aliosman.g101.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.aliosman.g101.R
import com.aliosman.g101.data.dao.CategoriesDao
import com.aliosman.g101.data.dao.ClothesDao
import com.aliosman.g101.data.entity.Brand
import com.aliosman.g101.data.entity.Category
import com.aliosman.g101.data.entity.Clothes
import com.aliosman.g101.data.entity.Color
import com.aliosman.g101.data.entity.Material
import com.aliosman.g101.data.entity.Season
import com.aliosman.g101.data.entity.Size
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [
        Clothes::class,
        Category::class,
        Season::class,
        Color::class,
        Brand::class,
        Size::class,
        Material::class
    ],
    version = 1,
)
abstract class AppDatabase: RoomDatabase() {

    // Clothes Dao
    abstract fun clothesDao(): ClothesDao

    // Categories Dao
    abstract fun categoriesDao(): CategoriesDao

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
                        "g101_db"
                    )
                        .fallbackToDestructiveMigration()
                        .addCallback(PrePopulateCallback(context))
                        //.createFromAsset("categories.sql")
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

    // Kategroiler için tanımlı verileri ekle
    private class PrePopulateCallback(private val context: Context) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            // String kaynaklarını ID'leriyle al.
            val dressId = R.string.dress
            val pantId = R.string.pant
            val shoeId = R.string.shoe
            val jacketId = R.string.jacket
            val skirtId = R.string.skirt
            val tshirtId = R.string.tshirt
            val accessoriesId = R.string.accessories
            val sweaterId = R.string.sweater
            val suitId = R.string.suit
            val glassesId = R.string.glasses
            val perfumeId = R.string.perfume

            // Doğrudan SQL INSERT sorguları çalıştır.
            db.execSQL("INSERT INTO categories (categoryName) VALUES ($dressId)")
            db.execSQL("INSERT INTO categories (categoryName) VALUES ($pantId)")
            db.execSQL("INSERT INTO categories (categoryName) VALUES ($shoeId)")
            db.execSQL("INSERT INTO categories (categoryName) VALUES ($jacketId)")
            db.execSQL("INSERT INTO categories (categoryName) VALUES ($skirtId)")
            db.execSQL("INSERT INTO categories (categoryName) VALUES ($tshirtId)")
            db.execSQL("INSERT INTO categories (categoryName) VALUES ($accessoriesId)")
            db.execSQL("INSERT INTO categories (categoryName) VALUES ($sweaterId)")
            db.execSQL("INSERT INTO categories (categoryName) VALUES ($suitId)")
            db.execSQL("INSERT INTO categories (categoryName) VALUES ($glassesId)")
            db.execSQL("INSERT INTO categories (categoryName) VALUES ($perfumeId)")

        }
    }

    /*
        İlk başta PrePopulateCallback fonksiyonu içinde aşağıdaki yapılar vardı.
        R.string yapılarını Category sınıfından bir nesne listesi
        oluşturacak şekilde yazıp daha sonra bunu Room'a kaydettim ancak
        BU YÖNTEM HIZ AÇISINDAN OLDUKÇA YAVAŞ VE ZAHMETLİ KALDI. ÖYLEKİ
        UI TARAFINDA MENÜ BUTONUNA TIKLANINCA HENÜZ VERİTABANI OLUŞMADIĞI İÇİN
        NULL BİR MENÜ DÖNÜYORDU. Bu nedenle ilgili verileri
        doğruca SQL içine koyarak süreci hızlandırmayı tercih ettim.

        CoroutineScope(Dispatchers.IO).launch {

                // INSTANCE'a erişim (DAO'yu almak için)
                // Bu noktada INSTANCE henüz tam olarak başlatılmış olabilir,
                // bu nedenle INSTANCE'ı tekrar çağırmak yerine DAO'yu
                // doğrudan almanın daha güvenli yolları da mevcuttur.
                // Basitlik için INSTANCE'a erişiyoruz:
                val dao = INSTANCE?.categoriesDao()

                if (dao != null) {

                    println("AppDatabase içinde, Dao null değil")
                    val defaultCategories = listOf(
                        Category(categoryName = R.string.dress),
                        Category(categoryName = R.string.pant),
                        Category(categoryName = R.string.shoe),
                        Category(categoryName = R.string.jacket),
                        Category(categoryName = R.string.skirt),
                        Category(categoryName = R.string.tshirt),
                        Category(categoryName = R.string.accessories),
                        Category(categoryName = R.string.sweater),
                        Category(categoryName = R.string.suit),
                        Category(categoryName = R.string.glasses),
                        Category(categoryName = R.string.perfume)
                    )

                    // Verileri Ekle
                    dao.insertAllCategories(defaultCategories)
                }
            }

     */

}

