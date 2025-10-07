package com.aliosman.g101.core.utils

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.aliosman.g101.R
import com.aliosman.g101.ui.categories.CategoriesDetailPage

abstract class BaseActivity : AppCompatActivity() {

    protected fun setupToolbar(toolbar: androidx.appcompat.widget.Toolbar) {
        // Set toolbar as an appbar
//        setSupportActionBar(toolbar).apply {
//            title = null
//        }
        // Listen to the appbar back button clicks
        toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
