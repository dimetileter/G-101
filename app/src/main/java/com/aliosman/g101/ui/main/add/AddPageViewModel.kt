package com.aliosman.g101.ui.main.add

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddPageViewModel: ViewModel() {

    private val _selectedImageUri = MutableLiveData<Uri?>()
    val selectedImageUri: LiveData<Uri?> = _selectedImageUri

    /**
     * Fragment'ların veriyi değiştirmek için kullanacağı tek yol bu fonksiyondur.
     * Bu fonksiyon, URI'ın null olabileceğini de kabul ediyor, bu doğru bir yaklaşım.
     */
    fun onImageSelected(uri: Uri?) {
        _selectedImageUri.value = uri
    }
}