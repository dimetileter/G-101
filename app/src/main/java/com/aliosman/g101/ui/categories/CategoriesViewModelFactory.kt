package com.aliosman.g101.ui.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aliosman.g101.data.repository.CategoryRepository
import com.aliosman.g101.data.repository.ClothesRepository

class CategoriesViewModelFactory(
    private val clothesRepository: ClothesRepository,
    private val categoriesRepository: CategoryRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Ekstra güvenlik için bağlanan ViewModel'i kontrol et
        if (modelClass.isAssignableFrom(CategoriesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CategoriesViewModel(clothesRepository, categoriesRepository) as T
        }
        // ViewModel bağlantısı CategoriesViewModel değil ise hata fırlat
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}