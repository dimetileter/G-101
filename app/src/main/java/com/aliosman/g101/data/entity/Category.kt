package com.aliosman.g101.data.entity

import android.content.Context
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class Category(
    @PrimaryKey(autoGenerate = true) val categoryId: Long = 0L,
    val categoryName: Int // R.string resources
)
//{
//    // String.xml dosyasındaki isimleri getir, string olarak çözümle ve geri döndür.
//    fun getLocalizedName(context: Context): String {
//        val resId = context.resources.getIdentifier(
//            categoryName,
//            "string",
//            context.packageName
//        )
//
//        return if (resId != 0) {
//            context.resources.getString(resId)
//        }
//        else {
//            categoryName
//        }
//    }
//}