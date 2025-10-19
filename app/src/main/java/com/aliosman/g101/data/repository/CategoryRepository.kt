package com.aliosman.g101.data.repository

import androidx.lifecycle.LiveData
import com.aliosman.g101.data.dao.CategoriesDao
import com.aliosman.g101.data.entity.Category

class CategoryRepository(private val categoryDao: CategoriesDao) {

    //Insert
    suspend fun insertCategory(category: Category) {
        categoryDao.insertCategories(category)
    }

    // Delete
    suspend fun deleteCategory(category: Category) {
        categoryDao.deleteCategories(category)
    }

    // get all categories
    suspend fun getAllCategories(): LiveData<List<Category>> {
        return categoryDao.getAllCategories()
    }

}
