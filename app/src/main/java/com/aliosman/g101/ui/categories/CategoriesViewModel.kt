package com.aliosman.g101.ui.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aliosman.g101.data.entity.Category
import com.aliosman.g101.data.entity.Clothes
import com.aliosman.g101.data.repository.CategoryRepository
import com.aliosman.g101.data.repository.ClothesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CategoriesViewModel(
    private val clothesRepository: ClothesRepository,
    private val categoriesRepository: CategoryRepository
    ): ViewModel() {

        // Is there any loading process
        private val _isLoading = MutableLiveData<Boolean>()
        val isLoading: LiveData<Boolean> = _isLoading

        // Is there an error
        private val _isThereError = MutableLiveData<Boolean>()
        val isThereError: LiveData<Boolean> = _isThereError

        // Get clothes list
        private val _clothesList = MutableLiveData<List<Clothes>>()
        val clothesList: LiveData<List<Clothes>> = _clothesList

        // Filtered Clothes list live data
        private val _filteredClothes = MutableLiveData<List<Clothes>>()
        val filteredClothes: LiveData<List<Clothes>> = _filteredClothes

        // Load categories
        private val _categoriesList = MutableLiveData<List<Category>>()
        val categoriesList: LiveData<List<Category>> = _categoriesList

        init {
            // Gerekli tüm verileri yüklemek için fonksiyonları burada çağır.
            getAllCategories()
            getAllClothes()
        }

        /*
            --- Functions ---
         */

        // Filtered by category
        fun getClothesByCategory(categoryId: Int) {
            // Coroutie'i IO da başlat, veriyi çek ve Main'de veriyi aktar
            viewModelScope.launch(Dispatchers.IO) {
                val result = clothesRepository.getClothesByCategory(categoryId)
                withContext(Dispatchers.Main) {
                    _clothesList.value = result
                }
            }
        }

        // get all clothes as list
        fun getAllClothes() {
            // Coroutie'i IO da başlat, veriyi çek ve Main'de veriyi aktar
            viewModelScope.launch(Dispatchers.IO) {
                val result = clothesRepository.getAllClothes()
                withContext(Dispatchers.Main) {
                    _clothesList.value = result
                }
            }
        }


        // Get categories list
        fun getAllCategories() {
            // Coroutie'i IO da başlat, veriyi çek ve Main'de veriyi aktar
            viewModelScope.launch(Dispatchers.IO) {
                val result = categoriesRepository.getAllCategories()
                withContext(Dispatchers.Main) {
                    _categoriesList.value = result
                }
            }
        }
    }